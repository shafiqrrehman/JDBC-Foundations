package com.connectDB.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectDB.jdbc.tables.Tours;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try(
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM tours");
				) {
			
			Tours.displayData(rs);

		} catch (SQLException e) {
			// TODO: handle exception
			DBUtil.processExceptions(e);
		} 
	}
}
