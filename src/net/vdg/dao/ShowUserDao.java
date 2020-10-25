package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import net.vdg.bean.UserBean;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ShowUserDao {

	public LinkedList<UserBean> showUser( String beanRole ) {
		
		String role = beanRole;
		LinkedList<UserBean> users = new LinkedList<UserBean>();
		
		String query = "select * from users where ROLE_ID = ?";
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setString( 1,  role );
				
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ) {
					UserBean user = new UserBean();
					
					user.setEmail( rs.getString( "USR_EMAIL" ) );
					user.setFirstName( rs.getString( "USR_FIRSTNAME" ) );
					user.setLastName( rs.getString( "USR_LASTNAME" ) );
					user.setRole( rs.getString( "ROLE_ID") );
					
					users.add( user );
				}
				
				
			}
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return users;

	}
}
