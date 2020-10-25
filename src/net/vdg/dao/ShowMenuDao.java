package net.vdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.vdg.bean.FoodBean;

public class ShowMenuDao {
	
	public LinkedList<FoodBean> show( String cat_id ){
		
		LinkedList<FoodBean> menu = new LinkedList<FoodBean>();
		String query = "select * from food where CAT_ID = ?";
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/di_grigoli" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setString( 1, cat_id );
				
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ) {
					FoodBean food = new FoodBean();
					
					food.setId( rs.getInt( "FOOD_ID" ) );
					food.setName( rs.getString( "FOOD_NAME" ) );
					food.setDescr( rs.getString( "FOOD_DESCR" ) );
					food.setPrice( rs.getFloat( "FOOD_PRICE" ) );
					
					
					menu.add( food );
				}
			}
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return menu;
	}

}
