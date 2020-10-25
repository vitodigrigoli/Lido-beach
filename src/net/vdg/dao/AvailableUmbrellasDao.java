package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.vdg.bean.UmbrellaBean;

public class AvailableUmbrellasDao {

	public LinkedList<UmbrellaBean> show( String date ){
		
		String query = "select * from umbrellas where UMB_ID not in ("
				+ "select ORD_DETAILS from orders where ORD_TYPE = 'U' and ORD_BOOKINGDATE = ? )";
		LinkedList<UmbrellaBean> umbrellas = new LinkedList<UmbrellaBean>();
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setString( 1, date );
				
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ) {
					UmbrellaBean umbrella = new UmbrellaBean();
					
					umbrella.setId( rs.getInt( "UMB_ID" ) );
					umbrella.setRow( rs.getInt( "UMB_ROW" ) );
					umbrella.setPlace( rs.getInt( "UMB_PLACE" ) );
					umbrella.setPrice( rs.getFloat( "UMB_PRICE" ) );
				
					umbrellas.add( umbrella );
					
				}
			}
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return umbrellas;
	}
}
