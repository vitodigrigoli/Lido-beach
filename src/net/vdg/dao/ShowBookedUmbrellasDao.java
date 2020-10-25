package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.vdg.bean.UmbrellaBean;

public class ShowBookedUmbrellasDao {
	
	public LinkedList<UmbrellaBean> show( String dateToday ){
		
		String query = "select UMB_ID, UMB_ROW, UMB_PLACE, USR_FIRSTNAME, USR_LASTNAME from orders, umbrellas, users where users.USR_EMAIL = orders.USR_EMAIL and ORD_DETAILS = UMB_ID and ORD_BOOKINGDATE = ?";
		LinkedList<UmbrellaBean> occupiedUmbrellas = new LinkedList<UmbrellaBean>();
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setString( 1, dateToday );
				
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ) {
					UmbrellaBean occupiedUmbrella = new UmbrellaBean();
					
					occupiedUmbrella.setId( rs.getInt( "UMB_ID" ) );
					occupiedUmbrella.setRow( rs.getInt( "UMB_ROW" ) );
					occupiedUmbrella.setPlace( rs.getInt( "UMB_PLACE" ) );
					occupiedUmbrella.setUserFirstName( rs.getString( "USR_FIRSTNAME" ) );
					occupiedUmbrella.setUserLastName( rs.getString( "USR_LASTNAME" ) );
					
					occupiedUmbrellas.add( occupiedUmbrella );
				}
			}
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return occupiedUmbrellas;
		}
	}
