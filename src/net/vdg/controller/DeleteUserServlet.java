package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.bean.UserBean;
import net.vdg.dao.DeleteUserDao;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserServlet() {
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
        String email = request.getParameter( "email" );
        
        // Create an User Bean and set email
        UserBean deleteBean = new UserBean();
        deleteBean.setEmail( email );
        
        // Delete the user from the database
        DeleteUserDao deleteUserDao = new DeleteUserDao();
        String result = deleteUserDao.deleteUser( deleteBean );
        
        if( result.equals( "SUCCESS" ) ) {
        	out.write( "<p class=\"green\">The user has been deleted from the database correctly</p>" );
        }
        
        else {
        	out.write( "<p class=\"red\">Oops! Something went wrong. Try again</p>" );
        }
	
	}

}
