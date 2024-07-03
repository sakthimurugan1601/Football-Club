package com.use;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View {

		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		public View() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbdb","root","root");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public ResultSet RetrievePlayer()
		{
			String sql="Select name,age,district,email,position,biodata from viewdetails";
			try {
				pst=con.prepareStatement(sql);
				rs=pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		public void StoreData(Player p)
		{
			String sql="insert viewdetails(Name, Age, District, Email, Position,Biodata) values(?, ?, ?, ?, ?, ?)";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, p.getname());
				pst.setInt(2, p.getage());
				pst.setString(3, p.getdistrict());
				pst.setString(4, p.getemail());
				pst.setString(5, p.getposition());
				pst.setBlob(6, p. getbiodata());;
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	
}
