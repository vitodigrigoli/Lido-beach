package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import net.vdg.bean.UserBean;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;
import java.sql.ResultSet;

public class LoginDao {

	public String loginUser( UserBean loginBean ) {
		
		String email = loginBean.getEmail();
		String password = loginBean.getPassword();
		
		String query = "select * from users where USR_EMAIL = ? and USR_PASSWORD = ?";
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setString( 1, email );
				ps.setString( 2, password );
				
				ResultSet rs = ps.executeQuery();
				
				if( rs.next() ) {
					loginBean.setFirstName( rs.getString( "USR_FIRSTNAME" ) );
					loginBean.setLastName( rs.getString( "USR_LASTNAME" ) );
					loginBean.setRole( rs.getString( "ROLE_ID" ) );
					
					return "SUCCESS";
				}
			}
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return "NOT FOUND";
	}
}
