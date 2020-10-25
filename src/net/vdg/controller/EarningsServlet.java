package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.dao.EarningsDao;

/**
 * Servlet implementation class EarningsTodayServlet
 */
@WebServlet("/EarningsServlet")
public class EarningsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EarningsServlet() {
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
        String dateFrom = request.getParameter( "dateFrom" );
        String dateTo = request.getParameter( "dateTo" );
        
        // Selects the sum of earnings for that date range from the database
        EarningsDao earningsDao = new EarningsDao();
        float earnings = earningsDao.showEarnings( dateFrom, dateTo );
        
        if( earnings != -1 ) {
        	out.write( "<p>&euro; " + String.valueOf( earnings ) + "</p>");
        }
        else {
        	out.write( "<p class=\"red\">Oops! Something went wrong.</p>");
        }       
	}

}
