package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.dao.ShowBookedUmbrellasDao;
import net.vdg.bean.UmbrellaBean;

/**
 * Servlet implementation class ShowBookedUmbrellaServlet
 */
@WebServlet("/ShowBookedsUmbrellasServlet")
public class ShowBookedUmbrellasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowBookedUmbrellasServlet() {
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
        
        // Select the umbrellas booked for that day
        ShowBookedUmbrellasDao bookedUmbrellasDao = new ShowBookedUmbrellasDao();
        LinkedList<UmbrellaBean> bookedUmbrellas = bookedUmbrellasDao.show( dateToday );
        
        // Displays the list of booked umbrellas
        if( !bookedUmbrellas.isEmpty() ) {
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>Umbrella ID</th>"
        			+ "<th>Row</th>"
        			+ "<th>Place</th>"
        			+ "<th>First Name</th>"
        			+ "<th>Last Name</th>"
        			+ "</tr>");
        	
        	for( int i = 0; i < bookedUmbrellas.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + bookedUmbrellas.get( i ).getId() + "</td>"
        				+ "<td>" + bookedUmbrellas.get( i ).getRow() + "</td>"
        				+ "<td>" + bookedUmbrellas.get( i ).getPlace() + "</td>"
        				+ "<td>" + bookedUmbrellas.get( i ).getUserFirstName() + "</td>"
                		+ "<td>" + bookedUmbrellas.get( i ).getUserLastName() + "</td>"
       					+ "</tr>");
        		
        	}
        	
        	out.write( "</table>" );
        }
        
        else {
        	out.write( "<p>No umbrella booked for today</p>");
        }
        
	}

}
