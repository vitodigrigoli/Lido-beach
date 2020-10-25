package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.vdg.bean.OrderBean;

public class OrdersDao {

	public LinkedList<OrderBean> showOrders( String typeOrder, String dateFrom, String dateTo ) {
		
		String query = "select * from orders where ORD_TYPE = ? and ORD_DATE between ? and ?";
		
		LinkedList<OrderBean> orders = new LinkedList<OrderBean>();
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setString( 1, typeOrder );
				ps.setString( 2, dateFrom );
				ps.setString( 3, dateTo );
				
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ) {
					OrderBean order = new OrderBean();
					
					order.setId( rs.getInt( "ORD_ID" ) );
					order.setDate( rs.getString( "ORD_DATE" ) );
					order.setTime( rs.getString( "ORD_TIME" ) );
					order.setEmail( rs.getString( "USR_EMAIL" ) );
					order.setType( rs.getString( "ORD_TYPE" ) );
					order.setBookingDate( rs.getString( "ORD_BOOKINGDATE" ) );
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
