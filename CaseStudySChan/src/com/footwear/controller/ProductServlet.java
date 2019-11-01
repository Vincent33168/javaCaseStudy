package com.footwear.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.footwear.dao.ProductDAO;
import com.footwear.model.Item;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String paramName1 = "param1";
//        String paramValue1 = request.getParameter(paramName1)  ;
//        String paramName2 = "param2";
//        String paramValue2 = request.getParameter(paramName2) ;
//        
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/plain");
//        out.write(paramName1);
//        out.write(" = ");
//        out.write(paramValue1);
//        
//        out.write(paramName2);
//        out.write(" = ");
//        out.write(paramValue2);
      
        
		//get the product data from help class (model)
       List<Item> items = ProductDAO.getItemsByCategory(request.getParameter("cat") , request.getParameter("subcat"));
    	//List<Item> items = ProductDAO.getItemsByCategory("MEN", "BOOT");
		//out.write(Integer.toString(items.size()));	
		
		
		//add items to request object
		request.setAttribute("ITEMLIST", items);
	
		
		//get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("product_list.jsp");
		
		//forward to JSP
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
