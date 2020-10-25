package net.vdg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.dao.CompleteOrderKitchenDao;

/**
 * Servlet implementation class CompleteOrderKitchenServlet
 */
@WebServlet("/CompleteOrderKitchenServlet")
public class CompleteOrderKitchenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompleteOrderKitchenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Copying all the input parameters in to local variables
		int orderID;
		
		try {
			orderID = Integer.parseInt( request.getParameter( "orderID" ) );
		}
		catch( Exception e ) {
			orderID = 0;
		}
		

        // Completes the kitchen order by changing the value of the ORD_COMPLETED attribute to "Y"
        CompleteOrderKitchenDao completeOrderKitchenDao = new CompleteOrderKitchenDao();
        String rs = completeOrderKitchenDao.completeOrder( orderID );
        
        response.getWriter().write( rs );
	
	}

}
