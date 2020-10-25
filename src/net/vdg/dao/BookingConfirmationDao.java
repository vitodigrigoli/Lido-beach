package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;
import java.sql.ResultSet;

import net.vdg.bean.UmbrellaBean;

public class BookingConfirmationDao {
	
	public String setData( UmbrellaBean umbrella ) {
		
		String query = "SELECT * FROM umbrellas where UMB_ID = ?";
		int umbrellaID = umbrella.getId();
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setInt( 1,  umbrellaID );
				
				ResultSet rs = ps.executeQuery();
				
				if( rs.next() ) {
					umbrella.setRow( rs.getInt( "UMB_ROW" ) );
					umbrella.setPlace( rs.getInt( "UMB_PLACE" ) );
					umbrella.setPrice( rs.getFloat( "UMB_PRICE" ) );
					
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
