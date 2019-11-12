package com.footwear.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footwear.dao.CustomerServiceI;
import com.footwear.dao.ItemServiceI;
import com.footwear.dao.OrderDetailServiceI;
import com.footwear.dao.OrdersServiceI;
import com.footwear.model.Customer;
import com.footwear.model.Item;
import com.footwear.model.OrderDetail;
import com.footwear.model.Orders;
import com.footwear.service.UserService;

@Controller
public class OrderController {
	@Autowired
	OrdersServiceI orderService;

	@Autowired
	OrderDetailServiceI orderDetailService;

	@Autowired
	ItemServiceI itemService;

	@Autowired
	UserService userService;

	@Autowired
	CustomerServiceI customerService;

	public String SKU;
	public double sub_total;
	public double tax;
	public double total;
	public double deletedItemAmount;
	public double deletedItemTax;
	public double deletedItemTotal;
	public OrderDetail orderDetail;
	public Set<OrderDetail> od;
	public boolean sameSKU = false;
	ModelAndView mav;

	// Add selected product to SHOPPING CART
	@RequestMapping(value = "/addToCart/{selectedItem}", method = RequestMethod.POST)
	public ModelAndView addItemToCart(@ModelAttribute("CartObj") Item item, BindingResult br,
			@PathVariable int selectedItem, @RequestParam(value = "quantity") String oqty,
			@RequestParam(value = "color") String color, @RequestParam(value = "size") String size,
			RedirectAttributes redirect) {

		System.out.println(oqty + "|" + color + "|" + size);

		ModelAndView mav;
		if (br.hasErrors()) {
			System.out.println(br.getErrorCount());
		}

		// Find the customer by user login
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// Redirect to login page if not logged in

		if (("anonymousUser").equals(authentication.getName())) {
			redirect.addFlashAttribute("message", "Please Login to continue shopping!");
			mav = new ModelAndView("redirect:/login");
			return mav;
		}
		String username = authentication.getName();
		Customer customer = userService.getUserByUsername(username).getCustomer();

		// check if order qty is zero and return to cartList with error message
		int qty;
		if ((oqty.trim().length() == 0)) {
			mav = new ModelAndView("buyItemForm");
			mav.addObject("SELECTEDITEM", itemService.getItem(selectedItem));
			mav.addObject("message", "Fill in Quantity!");
			return mav;
		} else {
			qty = Integer.valueOf(oqty);
		}

		// check if any pending order in CART
		// if found, add the selected item to existing order, otherwise create a new
		// order.
		Set<Orders> orderInCart = new HashSet<Orders>();
		orderInCart = orderService.findByStatusAndCustomer("Cart", customer);
		Orders neworder;
		Item itemOrdered;

		itemOrdered = itemService.getItem(selectedItem);

		// One product may have multiple colors and sizes
		// Need to find the specific SKU and Item Detail ID from the Selected Item
		// Detail
		// Then add it to order detail table
		itemOrdered.getItemdetail().forEach((odetail) -> {
			if (odetail.getColor().equals(color) && odetail.getSize().equals(size)) {
				SKU = odetail.getSku();
			}
		});

		sub_total = 0.0;
		tax = 0.0;
		total = 0.0;
		// Check if the selected product already in CART
		// if found, add the quantity and update the order total.
		if (orderInCart.size() != 0) {
			od = orderInCart.iterator().next().getOdetail();
			sameSKU = false;
			od.forEach((o) -> {
				// if (o.getColor().equals(color) && o.getSize().equals(size)) {
				if (o.getSku().equals(SKU)) {
					o.setQuantity(qty + o.getQuantity());
					sameSKU = true;
				}

				sub_total += (o.getQuantity() * 12) * o.getUnitprice();
				tax += o.getQuantity() * 12 * o.getUnitprice() * 8.875 / 100;

			});
			total = sub_total + tax;

		}

		// First Order or New Item added
		if (orderInCart.size() == 0 || !sameSKU) {
			// create the order detail object
			orderDetail = new OrderDetail();
			orderDetail.setName(itemOrdered.getName());
			orderDetail.setDesc(itemOrdered.getDesc());
			orderDetail.setPhoto(itemOrdered.getPhoto());
			orderDetail.setUnitprice(itemOrdered.getUnitprice());
			orderDetail.setColor(color);
			orderDetail.setSize(size);
			orderDetail.setQuantity(qty);
			orderDetail.setSku(SKU);

		}

		// First Order
		if (orderInCart.size() == 0) { // create new order
			neworder = new Orders();
			neworder.setCurrency(itemOrdered.getCurrency());
			neworder.setAmount(qty * itemOrdered.getUnitprice() * 12);
			neworder.setOdate(new Date());
			neworder.setStatus("Cart");
			double tax = qty * itemOrdered.getUnitprice() * 12 * 8.875 / 100;
			neworder.setTax(tax);
			neworder.setOrderTotal(qty * itemOrdered.getUnitprice() * 12 + tax);
			orderDetail.setOrders(neworder);

		} else { // update existing order
			neworder = orderInCart.iterator().next();
//				neworder.setAmount(sub_total + neworder.getAmount());
//				neworder.setTax(tax + neworder.getTax());
//				neworder.setOrderTotal(total + neworder.getOrderTotal());
			double amount_newOrder = qty * itemOrdered.getUnitprice() * 12;
			double tax_newOrder = amount_newOrder * 8.875 / 100;
			neworder.setAmount(sub_total + amount_newOrder);
			neworder.setTax(tax + tax_newOrder);
			neworder.setOrderTotal(total + amount_newOrder + tax_newOrder);
		}

		if (orderInCart.size() == 0 || !sameSKU) {
			neworder.addOrderDetail(orderDetail);
		}

		orderService.addOrders(neworder);

		Orders order = orderService.getOrder(neworder.getId());
		order.setCustomer(customer);
		orderService.addOrders(order);

		// Redirect to MY CART list page
		redirect.addFlashAttribute("message", "Product successfully added to Cart!");
		mav = new ModelAndView("redirect:/cartlist");
		return mav;
	}

	// Show products in CART
	@RequestMapping(value = "cartlist")
	public ModelAndView getCartList() {
		mav = new ModelAndView("viewCart");
		// Find the customer by user login
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Customer customer = userService.getUserByUsername(username).getCustomer();

		// get customer orders from DB, add order list to the view
		Set<Orders> orderList = orderService.findByStatusAndCustomer("Cart", customer);
		mav.addObject("myCartObj", orderList);
		if (orderList.isEmpty()) {
			mav.addObject("message", "Cart is empty !");
		}
		return mav;

	}

	// update order quantity in CART
	@RequestMapping(value = "/updateCart/{oId}/{odId}", method = RequestMethod.POST)
	public ModelAndView updateQty(@PathVariable int oId, @PathVariable int odId,
			@RequestParam(value = "quantity") int qty, RedirectAttributes redirect) {

		ModelAndView mav;

		System.out.println(oId + "|" + odId + "|" + qty);

		Orders order = orderService.getOrder(oId);
		// OrderDetail orderDetail = new OrderDetail();

		// update the order quantity for the line item, or remove it if quantity is zero
		// Set<OrderDetail> odSet = order.getOdetail();

		sub_total = 0.0;
		tax = 0.0;
		total = 0.0;
		deletedItemAmount = 0.0;
		deletedItemTax = 0.0;
		deletedItemTotal = 0.0;
	

		order.getOdetail().forEach((lineItem) -> {
			if (lineItem.getId() == odId) {
				if (qty > 0) {
					lineItem.setQuantity(qty);
				} else {
					deletedItemAmount = (lineItem.getQuantity() * 12) * lineItem.getUnitprice();
					deletedItemTax = (lineItem.getQuantity() * 12) * lineItem.getUnitprice() * 8.875 / 100;
					deletedItemTotal = deletedItemAmount + deletedItemTax;
				}

			}
			sub_total += (lineItem.getQuantity() * 12) * lineItem.getUnitprice();
			tax += (lineItem.getQuantity() * 12) * lineItem.getUnitprice() * 8.875 / 100;

		});

		// check if all item detail are deleted, remove the order as well
		// update total if order exists
		total = sub_total + tax;
		int itemCount = order.getOdetail().size();
		if (qty > 0) {
			order.setAmount(sub_total);
			order.setTax(tax);
			order.setOrderTotal(total);

		} else {
			order.setAmount(order.getAmount() - deletedItemAmount);
			order.setTax(order.getTax() - deletedItemTax);
			order.setOrderTotal(order.getOrderTotal() - deletedItemTotal);
			
		}
		orderService.addOrders(order);

		if (qty == 0) {
			orderDetailService.removeOrderDetail(odId);
			if (itemCount == 1) {
				orderService.deleteOrders(order);
			}
		}

//		if (itemCount ==1) {
//			orderService.deleteOrders(order);
//		}

		// Redirect to MY CART list page
		redirect.addFlashAttribute("message", "Cart is successfully updated!");
		mav = new ModelAndView("redirect:/cartlist");
		// mav = new ModelAndView("test");
		return mav;

	}

	@RequestMapping(value = "/confirmOrder/{oId}", method = RequestMethod.GET)
	public ModelAndView checkOutProcess(@PathVariable int oId) {
		// order confirmation process
		// change the order status to "Confirmed"
		// update the inventory quantity in Item table
		
		Orders order = orderService.getOrder(oId);
		order.setStatus("Confirmed");
		orderService.addOrders(order);
		// show confirmation message to user
		mav = new ModelAndView("confirmOrder");
		return mav;
	}

	@RequestMapping(value = "orderHistory", method = RequestMethod.GET)
	public ModelAndView showOrderHistory() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Customer customer = userService.getUserByUsername(username).getCustomer();
		mav = new ModelAndView("order_list");
		// get customer orders from DB, add order list to the view
		Set<Orders> orderList = orderService.findByStatusAndCustomer("Confirmed", customer);
		mav.addObject("myOrdersObj", orderList);
		
		return mav;
	}

	@RequestMapping(value="/viewOrderDetail/{oId}", method=RequestMethod.GET)
	public ModelAndView showOrderDetail(
			@PathVariable int oId, 
			RedirectAttributes redirect) {
		
		//get order from DB
		Orders order = orderService.getOrder(oId);
		
		//redirect to order list with order object
		//mav = new ModelAndView("redirect:/orderHistory");
		mav.addObject("selectedOrderObj", order);
		mav.addObject("selectedOrderId", order.getId());
		return mav;
		
	}
}
