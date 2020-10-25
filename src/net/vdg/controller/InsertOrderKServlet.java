package net.vdg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vdg.bean.CartBean;
import net.vdg.bean.OrderBean;
import net.vdg.bean.UserBean;
import net.vdg.dao.InsertOrderDao;

/**
 * Servlet implementation class InsertOrderKServlet
 */
@WebServlet("/InsertOrderKServlet")
public class InsertOrderKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertOrderKServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Getting beans in session
		HttpSession session = request.getSession();
		
		CartBean cart = ( CartBean ) session.getAttribute( "cart" );
		UserBean user = ( UserBean ) session.getAttribute( "user" );
	
		// Copying all the input parameters in to local variables
		String date = request.getParameter( "date" );
		String time = request.getParameter( "time" );
		String note = request.getParameter( "note" );
		String type = "K";
		String isCompleted = "N";
		String email = user.getEmail();
		float total = cart.getTotal();	
		
		String details = "";		
		for( int i = 0; i < cart.getList().size(); ++i ) {
			details += cart.getList().get(i).getName() + "; ";
		}	
		
		// Create Order Bean and set data
		OrderBean order = new OrderBean();
        order.setTime( time );
        order.setDate( date );
        order.setEmail( email );
        order.setType( type );
        order.setBookingDate( date );
        order.setDetails( details );
        order.setTotal( total );
        order.setNote( note );
        order.setIsCompleted( isCompleted );
		
        // Insert the kitchen order in the database
        InsertOrderDao insertOrder = new InsertOrderDao();
        String result = insertOrder.insert( order );
        
        response.getWriter().write( result );
				
	}

}
