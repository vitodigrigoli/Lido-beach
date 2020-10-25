package net.vdg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vdg.dao.BookingConfirmationDao;
import net.vdg.bean.OrderBean;
import net.vdg.bean.UmbrellaBean;

/**
 * Servlet implementation class BookingConfirmationServlet
 */
@WebServlet("/BookingConfirmationServlet")
public class BookingConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookingConfirmationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Copying all the input parameters in to local variables
		int umbrellaID;
		String bookingDate = request.getParameter( "bookingDate" );
		
		try {
			umbrellaID = Integer.parseInt( request.getParameter( "umbrellaID" ) );
		}
		catch( Exception e ) {
			umbrellaID = 0;
		}
		
		// Create Umbrella Bean and set ID
		UmbrellaBean umbrellaBean = new UmbrellaBean();
		umbrellaBean.setId( umbrellaID );
		
		
        // Let's set up all the data in the database for umbrella in the bean
		BookingConfirmationDao bookingConfirmation = new BookingConfirmationDao();
		String rs = bookingConfirmation.setData( umbrellaBean );
		
		
		if( rs.equals( "SUCCESS" ) ) {
			
			HttpSession session = request.getSession();
			session.setAttribute( "umbrella", umbrellaBean );
			
			OrderBean order = new OrderBean();
			order.setBookingDate( bookingDate );			
			session.setAttribute( "order", order );			
			}
	}

}
