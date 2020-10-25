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
import net.vdg.bean.FoodBean;
import net.vdg.dao.CartDao;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartServlet() {
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
		int foodID;
		
		try {
			foodID = Integer.parseInt( request.getParameter( "foodID" ) );
		}
		catch( Exception e ) {
			foodID = 0;
		}
		
		// Create Food Bean and set ID
		FoodBean foodBean = new FoodBean();
		foodBean.setId( foodID );
		
		// Let's set up all the data in the database for food in the bean
		CartDao cartDao = new CartDao();
		String rs = cartDao.setFood( foodBean );
		
		// Add Food Bean in the cart
		if( rs.equals( "SUCCESS" ) ) {
			
			HttpSession session = request.getSession();
			CartBean cart = ( CartBean ) session.getAttribute( "cart" );
			
			if( cart == null ) {
				cart = new CartBean();
			}
			
			cart.getList().add( foodBean );
			float total = cart.getTotal() + foodBean.getPrice();
			cart.setTotal( total );
			
			session.setAttribute( "cart", cart );
			
			out.write( foodBean.getName() + " has been added to your cart" );
		}
		
		else {
			out.write( "Oops! There's been an error" );

		}
		
		
		
	}

}
