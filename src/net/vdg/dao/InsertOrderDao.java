package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.vdg.bean.OrderBean;

public class InsertOrderDao {
	
	public String insert( OrderBean order ) {
		
		String date = order.getDate();
		String time = order.getTime();
		String email = order.getEmail();
		String type = order.getType();
		String bookingDate = order.getBookingDate();
		String details = order.getDetails();
		float total = order.getTotal();
		String note = order.getNote();
		String isCompleted = order.getIsCompleted();
		
		String query = "insert into orders( ORD_DATE, ORD_TIME, USR_EMAIL, ORD_TYPE, ORD_BOOKINGDATE, ORD_DETAILS, ORD_TOTAL, ORD_NOTE, ORD_COMPLETED )"
				+ "values( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		try{
       	 Context ctx = new InitialContext();
			 DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/di_grigoli");
			 
			 try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ){
    
            ps.setString( 1, date );
            ps.setString( 2, time );
            ps.setString( 3, email );
            ps.setString( 4, type );
            ps.setString( 5, bookingDate );
            ps.setString( 6, details );
            ps.setFloat( 7 , total );
            ps.setString( 8, note );
            ps.setString( 9, isCompleted );
            
            
            int i= ps.executeUpdate();
            
            if ( i!=0 )  //Just to ensure data has been inserted into the database
            return "SUCCESS";
			 }
        }
        
        catch(Exception e){
           e.printStackTrace();
        }      
        
        return "Oops! Something went wrong there.";  // On failure, send a message from here.

	}

}
