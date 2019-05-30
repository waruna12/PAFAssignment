package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.resources.DBConnect;

public class ItemDAO {
	
	private Connection con;
	
	public ItemDAO() {
		
		con = DBConnect.createConnection();
		
	}
	public String AddItem(String name,String brand, int qty, String color ) {
		
		Statement stmt = null;
		String sql = null;
		String res = null;
		try {
			
			sql = "INSERT INTO item_db(name, brand, qty, color) VALUES ('"+name+"','"+brand+"','"+qty+"','"+color+"')";
			
			stmt = con.createStatement();
			
			stmt.executeUpdate(sql);
			res = "Successfully inserted..."; 
			
		} catch (SQLException e) {
			
			e.printStackTrace();

		}
		return res;
		
	}
	public String DeleteItem(int id) {
		String res = null;
		try {
			
			PreparedStatement stmt = con.prepareStatement("DELETE FROM item_db WHERE id = ?");
			stmt.executeUpdate();
			res = "Successfully deleted...";
			
		} catch (SQLException e) {
			
			e.printStackTrace();

		}
		return res;
	}
	public String UpdateItem(String name,String brand,int qty,String color,int id){
		
		String res = null;
		try {
			
			PreparedStatement stmt = con.prepareStatement("UPDATE item_db SET name = '"+name+"', brand = '"+brand+"', qty = '"+qty+"', color = '"+color+"' WHERE id = '"+id+"'");
				
			stmt.executeUpdate();
			res = "Successfully updated...";
			
		} catch (SQLException e) {
			
			e.printStackTrace();

		}
		return res;
		
	}
	public String GetItems() {

		 String itemsGrid = null;
		 Connection con = null;
		 Statement st = null;
		 ResultSet rs = null;

		 try {
			 con = DBConnect.createConnection();
			 st = con.createStatement();
			 rs = st.executeQuery("select * from item_db");
			 if (rs.first())
			 {
	
				itemsGrid = "<table border='1' cellspacing='1'cellpadding='1'><tr><th>Name</th><th>Brand</th><th>Quantity</th><th>Color</th><th>Edit</th><th>Delete</th></tr>";
		
				rs.beforeFirst();
				while(rs.next()){
					itemsGrid = itemsGrid + "<tr><td>" + rs.getString(2) + "</td>"+ "<td>" + rs.getString(3) + "</td>"+ "<td>" + rs.getString(4) + "</td>"+ "<td>" + rs.getString(5) + "</td>" + "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\"param=\"" + rs.getString(1) + "\" value=\"Edit\"</td>"+ "<td>" + "<input id=\"btnRemove\" type=\"button\"name=\"btnRemove\" param=\"" + rs.getString(1) + "\"value=\"Remove\"</td></tr>";
				}
			 }
			 else
				 itemsGrid = "There are no items...";
				 itemsGrid = itemsGrid + "</table></br>";
			 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }

		 return itemsGrid;
		 } 
}
