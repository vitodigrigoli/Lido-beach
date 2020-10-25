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
 * Servlet implementation class ShowCartServlet
 */
@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowCartServlet() {
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
		
		// Display the contents of the shopping cart
		else {
			out.write( "<table>");
			
			for( int i = 0; i < cart.getList().size(); ++i ) {
				out.write( "<tr>"
						+ "<td>" + cart.getList().get( i ).getName() + "</td>"
						+ "<td>&euro;" + cart.getList().get( i ).getPrice() + "<i class=\"fas fa-minus-square\" id=\"" + i + "\"></i></td>"
						+ "</tr>");
			}
			
			out.write( "<tr>"
					+ "<td>TOTAL</td>"
					+ "<td>&euro;" + cart.getTotal() + "</td>"
					+ "</tr>"
					+ "</table>" );
		}
	}

}
