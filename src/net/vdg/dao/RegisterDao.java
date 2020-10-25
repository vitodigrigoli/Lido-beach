package net.vdg.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import net.vdg.bean.UserBean;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;

 
public class RegisterDao { 
     public String registerUser(UserBean registerBean){
         String firstName = registerBean.getFirstName();
         String lastName = registerBean.getLastName();
         String email = registerBean.getEmail();   
         String password = registerBean.getPassword();
         String role = registerBean.getRole();
         
       //Insert user details into the table 'user'
         String query = "insert into users( USR_EMAIL, USR_PASSWORD, USR_FIRSTNAME, USR_LASTNAME, ROLE_ID ) values (?,?,?,?,?)"; 
         
         try{
        	 Context ctx = new InitialContext();
 			 DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/di_grigoli");
 			 
 			 try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ){
     
             ps.setString(1, email);
             ps.setString(2, password);
             ps.setString(3, firstName);
             ps.setString(4, lastName);
             ps.setString(5, role );
             
             int i= ps.executeUpdate();
             
             if ( i!=0 )  //Just to ensure data has been inserted into the database
             return "SUCCESS";
 			 }
         }
         
         catch(Exception e){
            e.printStackTrace();
         }      
         
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
}
