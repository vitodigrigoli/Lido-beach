package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.dao.AvailableUmbrellasDao;
import net.vdg.bean.UmbrellaBean;


/**
 * Servlet implementation class AvailableUmbrellasServlet
 */
@WebServlet("/AvailableUmbrellasServlet")
public class AvailableUmbrellasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AvailableUmbrellasServlet() {
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
		String date = request.getParameter( "date" );
		
        // We are going to select the available umbrellas for that date from the database
		AvailableUmbrellasDao availableUmbrellas = new AvailableUmbrellasDao();
		LinkedList<UmbrellaBean> umbrellas = availableUmbrellas.show( date );
		
		// Displays the list of available umbrellas
        if( !umbrellas.isEmpty() ) {
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>Umbrella ID</th>"
        			+ "<th>Row</th>"
        			+ "<th>Place</th>"
        			+ "<th>Price</th>"
        			+ "<th>Action</th>"
        			+ "</tr>");
        	
        	// Print data about the umbrella available
        	for( int i = 0; i < umbrellas.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + umbrellas.get( i ).getId() + "</td>"
        				+ "<td>" + umbrellas.get( i ).getRow() + "</td>"
        				+ "<td>" + umbrellas.get( i ).getPlace() + "</td>"
        				+ "<td>" + umbrellas.get( i ).getPrice() + "</td>"
        				+ "<td><i class=\"fas fa-cart-arrow-down\" id=\"" + umbrellas.get( i ).getId() + "\"></i></td>"
       					+ "</tr>");
        		
        	}
        	
        	out.write( "</table>" );
        }
        
        else {
        	out.write( "<p>No umbrellas available for this day</p>");
        }
		
		
		
		
		
		
		
	}

}
