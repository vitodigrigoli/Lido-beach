package net.vdg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vdg.dao.ShowMenuDao;
import net.vdg.bean.FoodBean;

/**
 * Servlet implementation class ShowMenuServlet
 */
@WebServlet("/ShowMenuServlet")
public class ShowMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowMenuServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting the response type
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		// Copying all the input parameters in to local variables
		String cat_id = request.getParameter( "cat_id" );
		
		// Displays the menu list filtered by category from the database
		ShowMenuDao showMenu = new ShowMenuDao();
		LinkedList<FoodBean> menu = showMenu.show( cat_id );
		
		//Displays the list of menu
        if( !menu.isEmpty() ) {
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>Food ID</th>"
        			+ "<th>Name</th>"
        			+ "<th>Description</th>"
        			+ "<th>Price</th>"
        			+ "<th style=\"width:10px\"></th>"
        			+ "</tr>");
        	
        	for( int i = 0; i < menu.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + menu.get( i ).getId() + "</td>"
        				+ "<td><b>" + menu.get( i ).getName() + "</b></td>"
        				+ "<td>" + menu.get( i ).getDescr() + "</td>"
        				+ "<td>&euro;" + menu.get( i ).getPrice() + "</td>"
        				+ "<td><i class=\"fas fa-plus-square\" \"></i></td>"
        				+ "</tr>");
        	}
        	
        	out.write( "</table>");
        }
        
        else {
        	out.write( "<p>No food found</p>");
        }
		
	}

}
