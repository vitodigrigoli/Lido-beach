package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;
import java.sql.ResultSet;

public class EarningsDao {

	public float showEarnings( String dateFrom, String dateTo ) {
		
	String query = "select sum(ORD_TOTAL) as SUM from orders where ORD_DATE between ? and ?";
	float earnings = -1;
	
	try {
		Context ctx = new InitialContext();
		DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
		
		try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
			
			ps.setString( 1,  dateFrom );
			ps.setString( 2, dateTo );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				earnings = rs.getFloat( "SUM" );
			}
		}
	}
	
	catch( Exception e ) {
		e.printStackTrace();
	}
	
	return earnings;
	}
}
