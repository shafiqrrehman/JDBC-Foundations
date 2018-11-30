package com.connectDB.jdbc.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {
	public static void displayData(ResultSet rs) throws SQLException {
		
		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("Tour " + rs.getInt("tourId") + ": ");
			buffer.append(rs.getString("tourName"));
			
			Double price = rs.getDouble("price");
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			String formatedPrice = nf.format(price);
			buffer.append(" (" + formatedPrice + ") ");
			
			System.out.println(buffer.toString());
		}
	}
}
