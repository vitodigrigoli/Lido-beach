package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vdg.bean.CartBean;

/**
 * Servlet implementation class RemoveItemServlet
 */
@WebServlet("/RemoveItemServlet")
public class RemoveItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveItemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting the response type
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		// Getting Cart Bean in session
		HttpSession session = request.getSession();		
		CartBean cart = ( CartBean ) session.getAttribute( "cart" );
		
		if( cart == null || cart.getList().size() == 0 ){ 	
			out.write( "<p>The cart is empty</p>" );
		}
		else {
			
			// delete the item from the cart
			try {
				int itemIndex = Integer.parseInt( request.getParameter( "itemIndex" ) );
				float itemPrice = cart.getList().get( itemIndex ).getPrice();
				cart.setTotal( cart.getTotal() - itemPrice );
				cart.getList().remove( itemIndex );
			}
			catch( Exception e ){
				out.write( "<p>Internal Error!</p>" );
			}
		}
	
	}

}
