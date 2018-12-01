package com.connectDB.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectDB.jdbc.tables.States;
import com.connectDB.jdbc.tables.Tours;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try(
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM states");
				) {
			

			States.displayData(rs);
			rs.last();
			System.out.println("Numbers of rows: " + rs.getRow());
			
			rs.first();
			System.out.println("The firt state is: " + rs.getString("stateName"));
			
			rs.last();
			System.out.println("The lastt state is: " + rs.getString("stateName"));
			
			rs.absolute(11);
			System.out.println("The 11th state is: " + rs.getString("stateName"));

		} catch (SQLException e) {
			// TODO: handle exception
			DBUtil.processExceptions(e);
		} 
	}
}
