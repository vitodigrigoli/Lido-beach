package net.vdg.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import net.vdg.bean.UserBean;
import net.vdg.dao.RegisterDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 
    	 // Setting the response type
    	 response.setContentType( "text/html" );
    	 PrintWriter out = response.getWriter();
    	 
    	 // Copying all the input parameters in to local variables
         String firstName = request.getParameter( "firstName" );
         String lastName = request.getParameter( "lastName" );
         String email = request.getParameter( "email" );
         String password = request.getParameter( "password" );
         String role = request.getParameter( "role" );
         
         // Customer registration form case. The function "getParameter()", if it does not find the role parameter, sets the string to null without launching exceptions
         if( role == null ) {
        	 role = "C";
         }
         
         // Create User Bean and setting data
         UserBean registerBean = new UserBean();
         registerBean.setFirstName( firstName );
         registerBean.setLastName( lastName );
         registerBean.setEmail( email );
         registerBean.setPassword( password ); 
         registerBean.setRole( role );
                  
         // Register the user in the database
         RegisterDao registerDao = new RegisterDao();
         String userRegistered = registerDao.registerUser( registerBean );
         
         if(userRegistered.equals( "SUCCESS" ))   //On success, display a message to the user
         {
            out.write( "<p class=\"green\">The registration was successful." );
         }
         else   //On Failure, display a message to the User.
         {
        	 out.write( "<p class=\"red\">The registration was unsuccessful. This email has already been registered.</p>" );
         }
     }
}