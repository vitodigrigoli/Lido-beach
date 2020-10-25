package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.dao.OrdersDao;
import net.vdg.bean.OrderBean;

/**
 * Servlet implementation class CountOrder
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrdersServlet() {
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
        String typeOrder = request.getParameter( "typeOrder" );
        String dateFrom = request.getParameter( "dateFrom" );
        String dateTo = request.getParameter( "dateTo" );
        String printTableFlag = request.getParameter( "printTableFlag" );
        
        // Select all orders filtered by category (Umbrella - Kitchen) for that date range from the database
        OrdersDao ordersDao = new OrdersDao();
        LinkedList<OrderBean> orders = ordersDao.showOrders( typeOrder, dateFrom, dateTo );
        
        // Displays the list of orders
        if( printTableFlag.equals( "Y" ) ) {
        	
        	if( !orders.isEmpty() ) {
            	out.write( "<p>Number of ordes: " + orders.size() + "</p>");
            	out.write( "<table>"
            			+ "<tr>"
            			+ "<th>ID</th"
            			+ "><th>Date</th>"
            			+ "<th>Time</th>"
            			+ "<th>Email</th>"
            			+ "<th>Type</th>"
            			+ "<th>Booking Date</th>"
            			+ "<th>Details</th>"
            			+ "<th>Total</th>"
            			+ "<th>Note</th>"
            			+ "</tr>");
            	
            	for( int i = 0; i < orders.size(); ++i ) {
            		out.write( "<tr>"
            				+ "<td>" + orders.get( i ).getId() + "</td>"
            				+ "<td>" + orders.get( i ).getDate() + "</td>"
            				+ "<td>" + orders.get( i ).getTime() + "</td>"
            				+ "<td>" + orders.get( i ).getEmail() + "</td>"
            				+ "<td>" + orders.get( i ).getType() + "</td>"
            				+ "<td>" + orders.get( i ).getBookingDate() + "</td>"
            				+ "<td>" + orders.get( i ).getDetails() + "</td>"
            				+ "<td>" + orders.get( i ).getTotal() + "</td>"
            				+ "<td>" + orders.get( i ).getNote() + "</td>"
            				+ "</tr>");

            	}
            	
            	out.write( "</table>" );
            }
            else {
            	out.write( "<p>No result found</p>");
            } 
        }
        
        //Displays only size
        else {
        	out.write( "<p>" + orders.size() + "</p>");
        }
        
	}

}
