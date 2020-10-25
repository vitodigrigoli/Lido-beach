package net.vdg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vdg.bean.UserBean;
import net.vdg.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	
	public void init() {
		loginDao = new LoginDao();
	}
       
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
		
		String email = request.getParameter( "email" );
		String password = request.getParameter( "password" );
		
		UserBean loginBean = new UserBean();
		loginBean.setEmail( email );
		loginBean.setPassword( password );
		
		try {
			
			String result = loginDao.loginUser( loginBean );
			
			if( result.equals( "SUCCESS" ) ) {
				
				String role = loginBean.getRole();
				
				HttpSession session = request.getSession();
				session.setAttribute("user", loginBean );
				
				// case admin
				if( role.equals( "A" ) ) {

					response.sendRedirect( "/reserved/admin/dashboard.jsp" );		
				}
				// case client
				else if( role.equals( "C" ) ) {

					response.sendRedirect( "/reserved/client/booking.jsp" );		
				}
				// case kitchen
				else if( role.equals( "K" ) ) {

					response.sendRedirect( "/reserved/kitchen/orders.jsp" );		
				}
				// case life guard
				else if( role.equals( "LG" ) ){

					response.sendRedirect( "/reserved/lifeguard/view.jsp" );		
				}
				
			}
			
			else {
				request.setAttribute( "errorMsg", "<p>Wrong email or password</p>");
				request.getRequestDispatcher( "/view/login.jsp" ).forward(request, response);
				
			}
			
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
	}

}
