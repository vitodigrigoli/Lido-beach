package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import net.vdg.bean.UserBean;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;

public class DeleteUserDao {
	
	public String deleteUser( UserBean deleteBean ) {
		
		String email = deleteBean.getEmail();
		
		//Delete user from the table 'users'
        String query = "delete from users where USR_EMAIL = ?";
        
        try{
       	 Context ctx = new InitialContext();
			 DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/di_grigoli");
			 
			 try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ){
    
            ps.setString(1, email);
            
            int i= ps.executeUpdate();
            
            if ( i!=0 )  //Just to ensure data has been deleted from the database
            return "SUCCESS";
			 }
        }
        
        catch(Exception e){
           e.printStackTrace();
        }      
        
        return "Ops! Something went wrong there!";  // On failure, send a message from here.
        
	}

}
