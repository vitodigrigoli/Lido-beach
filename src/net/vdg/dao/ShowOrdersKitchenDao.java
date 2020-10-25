package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.vdg.bean.OrderBean;

public class ShowOrdersKitchenDao {
	
	public LinkedList<OrderBean> showOrders( String dateToday ) {
		
		String query = "select ORD_ID, USR_FIRSTNAME, USR_LASTNAME, ORD_DETAILS, ORD_TOTAL, ORD_NOTE from orders, users where users.USR_EMAIL = orders.USR_EMAIL and ORD_TYPE = 'K' and ORD_DATE = ? and ORD_COMPLETED = 'N'";
		LinkedList<OrderBean> orders = new LinkedList<OrderBean>();
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setString( 1, dateToday );
				
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ) {
					OrderBean order = new OrderBean();
					
					order.setId( rs.getInt( "ORD_ID" ) );
					order.setFirstName( rs.getString( "USR_FIRSTNAME" ) );
					order.setLastName( rs.getString( "USR_LASTNAME" ) );
					order.setDetails( rs.getString( "ORD_DETAILS" ) );
					order.setTotal( rs.getFloat( "ORD_TOTAL" ) );
					order.setNote( rs.getString( "ORD_NOTE" ) );
					
					orders.add( order );
					
				}
			}
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return orders;
		}
		

}
