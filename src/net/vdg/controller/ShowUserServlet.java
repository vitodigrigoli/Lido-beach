package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.bean.UserBean;
import net.vdg.dao.ShowUserDao;

/**
 * Servlet implementation class ShowUserServlet
 */
@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowUserServlet() {
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
        String role = request.getParameter( "role" );
        
        // The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        ShowUserDao showUserDao = new ShowUserDao();
        LinkedList<UserBean> users = showUserDao.showUser( role );
        
        // Displays the list of users
        if( !users.isEmpty() ) {
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>Email</th>"
        			+ "<th>First Name</th>"
        			+ "<th>Last Name</th>"
        			+ "<th>Role</th>"
        			+ "<th>Delete</th>"
        			+ "</tr>");
        	
        	for( int i = 0; i < users.size(); ++i ) {
        		out.write( "<tr><td>" + users.get( i ).getEmail() + "</td>"
        				+ "<td>" + users.get( i ).getFirstName() + "</td>"
        				+ "<td>" + users.get( i ).getLastName() + "</td>"
        				+ "<td>" + users.get( i ).getRole() + "</td>"
        				+ "<td><i class=\"fas fa-user-minus\" id=\"" + users.get( i ).getEmail() + "\"></i></td>"
       					+ "</tr>");
        		
        	}
        	
        	out.write( "</table>" );
        }
        
        else {
        	out.write( "<p>No result found</p>");
        }
	}

}
