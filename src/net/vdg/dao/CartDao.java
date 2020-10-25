package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.vdg.bean.FoodBean;

public class CartDao {
	
	public String setFood( FoodBean foodBean ) {
		
		String query = "select * from food where FOOD_ID = ?";

		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setInt( 1, foodBean.getId() );
				
				ResultSet rs = ps.executeQuery();
				
				if( rs.next() ) {
					
					foodBean.setDescr( rs.getString( "FOOD_DESCR" ) );
					foodBean.setName( rs.getString( "FOOD_NAME" ) );
					foodBean.setPrice( rs.getFloat( "FOOD_PRICE" ) );
					
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
