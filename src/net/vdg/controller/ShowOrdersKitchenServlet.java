package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.bean.OrderBean;
import net.vdg.dao.ShowOrdersKitchenDao;

/**
 * Servlet implementation class ShowOrdersKitchenServlet
 */
@WebServlet("/ShowOrdersKitchenServlet")
public class ShowOrdersKitchenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowOrdersKitchenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				// Setting the response type
				response.setContentType( "text/html" );
				PrintWriter out = response.getWriter();
				
				// Copying all the input parameters in to local variables
		        String dateToday = request.getParameter( "dateToday" );
		        
		        // Select kitchen orders for today
		        ShowOrdersKitchenDao ordersDao = new ShowOrdersKitchenDao();
		        LinkedList<OrderBean> orders = ordersDao.showOrders( dateToday );
		        
		        // Displays the list of orders
		        if( !orders.isEmpty() ) {
		        	
	            	out.write( "<table>"
	            			+ "<tr>"
	            			+ "<th>ID</th>"
	            			+ "<th>First Name</th>"
	            			+ "<th>Last Name</th>"
	            			+ "<th>Details</th>"
	            			+ "<th>Total</th>"
	            			+ "<th>Note</th>"
	            			+ "<th>Action</th>"
	            			+ "</tr>");
	            	
	            	for( int i = 0; i < orders.size(); ++i ) {
	            		out.write( "<tr>"
	            				+ "<td>" + orders.get( i ).getId() + "</td>"
	            				+ "<td>" + orders.get( i ).getFirstName() + "</td>"
	            				+ "<td>" + orders.get( i ).getLastName() + "</td>"
	            				+ "<td>" + orders.get( i ).getDetails() + "</td>"
	            				+ "<td>" + orders.get( i ).getTotal() + "</td>"
	            				+ "<td>" + orders.get( i ).getNote() + "</td>"
	            				+ "<td><i class=\"fas fa-check\" id=\"" + orders.get( i ).getId() + "\"></i></td>"
	            				+ "</tr>");
	            	}
	            	
	            	out.write( "</table>");
		        }
		        
		        else {
	            	out.write( "<p>No orders found</p>");
		        }
	}

}
