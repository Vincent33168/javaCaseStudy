package com.footwear.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footwear.model.Item;
import com.footwear.model.ItemDetail;
import com.footwear.model.OrderDetail;
import com.footwear.model.Orders;
import com.footwear.service.ItemService;
import com.footwear.service.OrdersService;


@Controller
public class ProductController {
	public static List<Item>itemList;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	OrdersService orderService;
	
	@RequestMapping(value = "/product",params = {"cat","subcat"}, method = RequestMethod.GET)
	public ModelAndView getProductList(
			@RequestParam(value = "cat") String category,
			@RequestParam(value = "subcat") String subcategory) {

		//for test
		//addTestData();
		System.out.println(category + "|"+ subcategory+"|");
		if (category!=null && subcategory!=null) {
			itemList = itemService.findByCategoryAndSubcategory(category, subcategory);
		}
		ModelAndView mav = new ModelAndView("product_list");
		mav.addObject("ITEMLIST",itemList);
		return mav;
	}
	
	@RequestMapping(value = "/productlist",method = RequestMethod.GET)
	public ModelAndView getProductList2() {
		ModelAndView mav = new ModelAndView("product_list");
		mav.addObject("ITEMLIST",itemList);
		return mav;
	}
	
	@RequestMapping(value="/buyitem/{selectedItem}")
	public ModelAndView buyItem(HttpSession session, @PathVariable int selectedItem,
			@CookieValue(value = "myCart", required = false) Item item) {
		//add selected item to cookies
		
		//Map<String ,Integer>map = new HashMap<String, Integer>();
		//map.put("1", 10);
	
//		Map<String, Item> cart = (Map<String, Item>) session.getAttribute("mycart");
//        if (cart==null) {
//        	session.setAttribute("mycart", cart);
//        } else {
//        	
//        	cart.put("1", item1);
//        }
//        
        ModelAndView mav = new ModelAndView("buyItemForm");
		mav.addObject("SELECTEDITEM", itemService.getItem(selectedItem));
		return mav;
        
	}
	
	@RequestMapping(value="/addToCart/{selectedItem}",method = RequestMethod.POST)
	public ModelAndView addItemToCart(@ModelAttribute("CartObj") Item item,
			BindingResult br,  @PathVariable int selectedItem,
			@RequestParam(value = "quantity") int qty,
			@RequestParam(value = "color") String color,
			@RequestParam(value = "size") String size,
			RedirectAttributes redirect) {
		
			System.out.println(qty+"|"+color+"|"+size);
			
			ModelAndView mav;
			if(br.hasErrors()) {
				System.out.println(br.getErrorCount());
			}
			//check if order qty is zero and return to cartList with error message
			if (qty==0) {
				mav = new ModelAndView("buyItemForm");
				mav.addObject("SELECTEDITEM", itemService.getItem(selectedItem));
				mav.addObject("message", "Quantity cannot be zero!");
				return mav;
			}
			
			//create the order object
			Item item2 = itemService.getItem(selectedItem);
			Orders neworder = new Orders();
			OrderDetail ordersDetail = new OrderDetail();
			ordersDetail.setName(item2.getName());
			ordersDetail.setDesc(item2.getDesc());
			ordersDetail.setColor(color);
			ordersDetail.setSize(size);
			ordersDetail.setQuantity(qty);
			ordersDetail.setUnitprice(item2.getUnitprice());
			//ordersDetail.setOrders(orders);
			Set<OrderDetail> od = new HashSet<>();
			od.add(ordersDetail);
			
			//check login user
			//neworder.setCustomer();
			neworder.setCurrency(item2.getCurrency());
			neworder.setAmount(qty*item2.getUnitprice());
			neworder.setOdate(new Date());
			neworder.setStatus("Unconfirm");
			double tax = qty*item2.getUnitprice() * 8.875/100;
			neworder.setTax(tax);
			neworder.setOrderTotal(qty*item2.getUnitprice()+tax);
			
			neworder.setOdetail(od);
			//check if this item already ordered or not
			//if in cart, add qty. Otherwise add new item to cart
			orderService.addOrders(neworder);
			
//			mav = new ModelAndView("viewCart");
			
//			mav.addObject("CARTLIST", itemService.getItem(selectedItem));
//		    redirect.addFlashAttribute("message", "Product successfully added to Cart"); 
		    mav = new ModelAndView("redirect:/cartlist");
//		    mav.addObject("ITEMLIST",itemList);
			
			return mav;
	}
	
	//helper method to create some test data for testing
	public void addTestData() {
		Item item1 = new Item();
		item1.setName("ANCHOR_02");
		item1.setDesc("MEN CASUAL");
		item1.setCategory("MEN");
		item1.setSubcategory("CASUAL");
		item1.setPhoto("photo/ANCHOR02.jpg");
		item1.setCurrency("USD");
		item1.setUnitprice(15.0);
		
		Item item2 = new Item();
		item2.setName("BAREA_01");
		item2.setDesc("MEN CASUAL");
		item2.setCategory("MEN");
		item2.setSubcategory("CASUAL");
		item2.setPhoto("photo/BAREA01.jpg");
		item2.setCurrency("USD");
		item2.setUnitprice(14.0);
		
		Item item3 = new Item();
		item3.setName("BLACKSTONE_01");
		item3.setDesc("MEN CASUAL");
		item3.setCategory("MEN");
		item3.setSubcategory("CASUAL");
		item3.setPhoto("photo/BLACKSTONE01.jpg");
		item3.setCurrency("USD");
		item3.setUnitprice(16.0);
		
		Item item4 = new Item();
		item4.setName("BYNUM_01");
		item4.setDesc("MEN CASUAL");
		item4.setCategory("MEN");
		item4.setSubcategory("CASUAL");
		item4.setPhoto("photo/BYNUM01.jpg");
		item4.setCurrency("USD");
		item4.setUnitprice(14.0);
		
		ItemDetail itemdetail11 =  new ItemDetail();
		itemdetail11.setColor("Black");
		itemdetail11.setSize("A");
		itemdetail11.setQuantity(100);
		itemdetail11.setSku("1001");
		itemdetail11.setItem(item1);
		
		ItemDetail itemdetail12 =  new ItemDetail();
		itemdetail12.setColor("Brown");
		itemdetail12.setSize("B");
		itemdetail12.setQuantity(200);
		itemdetail12.setSku("1002");
		itemdetail12.setItem(item1);
		
		ItemDetail itemdetail13 =  new ItemDetail();
		itemdetail13.setColor("Dark Brown");
		itemdetail13.setSize("C");
		itemdetail13.setQuantity(300);
		itemdetail13.setSku("1003");
		itemdetail13.setItem(item1);
		
		ItemDetail itemdetail21 =  new ItemDetail();
		itemdetail21.setColor("Black");
		itemdetail21.setSize("A");
		itemdetail21.setQuantity(100);
		itemdetail21.setSku("2001");
		itemdetail21.setItem(item2);
		
		ItemDetail itemdetail22 =  new ItemDetail();
		itemdetail22.setColor("Brown");
		itemdetail22.setSize("B");
		itemdetail22.setQuantity(200);
		itemdetail22.setSku("2002");
		itemdetail22.setItem(item2);
		
		ItemDetail itemdetail23 =  new ItemDetail();
		itemdetail23.setColor("Dark Brown");
		itemdetail23.setSize("C");
		itemdetail23.setQuantity(300);
		itemdetail23.setSku("2003");
		itemdetail23.setItem(item2);

		ItemDetail itemdetail31 =  new ItemDetail();
		itemdetail31.setColor("Black");
		itemdetail31.setSize("A");
		itemdetail31.setQuantity(100);
		itemdetail31.setSku("3001");
		itemdetail31.setItem(item3);
		
		ItemDetail itemdetail32 =  new ItemDetail();
		itemdetail32.setColor("Brown");
		itemdetail32.setSize("B");
		itemdetail32.setQuantity(200);
		itemdetail32.setSku("3002");
		itemdetail32.setItem(item3);
		
		ItemDetail itemdetail33 =  new ItemDetail();
		itemdetail33.setColor("Dark Brown");
		itemdetail33.setSize("C");
		itemdetail33.setQuantity(300);
		itemdetail33.setSku("3003");
		itemdetail33.setItem(item3);
		
		ItemDetail itemdetail41 =  new ItemDetail();
		itemdetail41.setColor("Black");
		itemdetail41.setSize("A");
		itemdetail41.setQuantity(100);
		itemdetail41.setSku("4001");
		itemdetail41.setItem(item4);
		
		ItemDetail itemdetail42 =  new ItemDetail();
		itemdetail42.setColor("Brown");
		itemdetail42.setSize("B");
		itemdetail42.setQuantity(200);
		itemdetail42.setSku("4002");
		itemdetail42.setItem(item4);
		
		ItemDetail itemdetail43 =  new ItemDetail();
		itemdetail43.setColor("Dark Brown");
		itemdetail43.setSize("C");
		itemdetail43.setQuantity(300);
		itemdetail43.setSku("4003");
		itemdetail43.setItem(item4);
		
		
		List<ItemDetail> itemDetail1 = new ArrayList<ItemDetail>();
		itemDetail1.add(itemdetail11);
		itemDetail1.add(itemdetail12);
		itemDetail1.add(itemdetail13);
		item1.setItemdetail(itemDetail1);
		

		List<ItemDetail> itemDetail2 = new ArrayList<ItemDetail>();
		itemDetail2.add(itemdetail21);
		itemDetail2.add(itemdetail22);
		itemDetail2.add(itemdetail23);
		item2.setItemdetail(itemDetail2);
		
		
		List<ItemDetail> itemDetail3 = new ArrayList<ItemDetail>();
		itemDetail3.add(itemdetail31);
		itemDetail3.add(itemdetail32);
		itemDetail3.add(itemdetail33);
		item3.setItemdetail(itemDetail3);
		
		List<ItemDetail> itemDetail4 = new ArrayList<ItemDetail>();
		itemDetail4.add(itemdetail41);
		itemDetail4.add(itemdetail42);
		itemDetail4.add(itemdetail43);
		item4.setItemdetail(itemDetail4);
		
//		itemService.addItem(item1);
//		itemService.addItem(item2);
//		itemService.addItem(item3);
//		itemService.addItem(item4);
		
	}
	
}
