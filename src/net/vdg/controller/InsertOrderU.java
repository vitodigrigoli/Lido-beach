package net.vdg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vdg.bean.OrderBean;
import net.vdg.bean.UmbrellaBean;
import net.vdg.bean.UserBean;
import net.vdg.dao.InsertOrderDao;

/**
 * Servlet implementation class InsertOrderUmbrella
 */
@WebServlet("/InsertOrderU")
public class InsertOrderU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertOrderU() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Getting bean in session
		HttpSession session = request.getSession();
		UmbrellaBean umbrella = ( UmbrellaBean ) session.getAttribute( "umbrella" );
		UserBean user = ( UserBean ) session.getAttribute( "user" );
		OrderBean order = ( OrderBean ) session.getAttribute( "order" );
		
		// Copying all the input parameters in to local variables
		String time = request.getParameter( "time" );
		String note = request.getParameter( "note" );
		String date = request.getParameter( "date" );
		
		String type = "U";
		String isCompleted = "Y";
		
		String email = user.getEmail();
		
		String details; 
		try {
			details = Integer.toString( umbrella.getId() );
		}
		catch( Exception e ) {
			details = "null";
		}
		
		float total = umbrella.getPrice();
		
		// Set the bean order data
        order.setTime( time );
        order.setDate( date );
        order.setEmail( email );
        order.setType( type );
        order.setDetails( details );
        order.setTotal( total );
        order.setNote( note );
        order.setIsCompleted( isCompleted );
        
        // Insert the order of the umbrella in the database
        InsertOrderDao insertOrder = new InsertOrderDao();
        String result = insertOrder.insert( order );
        
        response.getWriter().write( result );
	
	}
}
