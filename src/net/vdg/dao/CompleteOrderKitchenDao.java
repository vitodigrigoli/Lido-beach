package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CompleteOrderKitchenDao {

	public String completeOrder( int orderID ) {
		
		String query = "UPDATE orders SET ORD_COMPLETED = 'Y' WHERE ORD_ID  = ?";
		
		try{
       	 Context ctx = new InitialContext();
			 DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/di_grigoli");
			 
			 try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ){
    
	            ps.setInt(1, orderID );
	
	            
	            int i= ps.executeUpdate();
	            
	            if ( i!=0 ) {  //Just to ensure data has been inserted into the database
	            	return "SUCCESS";
	            }
			 }
        }
        
        catch(Exception e){
           e.printStackTrace();
        }      
        
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
	
}
