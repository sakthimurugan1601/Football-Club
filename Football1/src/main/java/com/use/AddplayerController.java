package com.use;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/AddplayerController")
@MultipartConfig(maxFileSize = 16177215)

public class AddplayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String driver ="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/vsbdb";
	String unm="root";
	String pwd ="root";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name").trim();
		String a= request.getParameter("age").trim();
		String district= request.getParameter("district").trim();
		String email= request.getParameter("email").trim();
		String position= request.getParameter("position").trim();
    	int age=Integer.parseInt(a);

		 InputStream istrm=null; 
		 Part fp=request.getPart("biodata");
		 if( fp!=null) {
		  System.out.println(fp.getName()); 
		  System.out.println(fp.getSize());
		  System.out.println(fp.getContentType());
		  istrm =fp.getInputStream(); 
		  }
		  Connection con=null; 
		  String msg=null;
		  try {
		 DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
		 con=DriverManager.getConnection(url,unm,pwd);
		  
		 String sql ="insert into viewdetails(name, age, district, position, email, biodata)"+" values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, district);
			pst.setString(4, position);
			pst.setString(5, email);

			if(istrm!=null)
			{
				pst.setBlob(6, istrm);
			}
			int res= pst.executeUpdate();
			if(res>0)
			{
				msg="Player Data Uploaded Successfully..!!!!!!";
			}
			
			con.close();
			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  ArrayList<String> list1=new ArrayList<String>();
			if(name.length()==0)
			{
				list1.add("");
			}
			if(age<18)
			{
				list1.add("Enter Name Field");
			}
			if(district.length()==0)
			{
				list1.add("Enter District Field");
			}
			if(position.length()==0)
			{
				list1.add("Enter Position Field");
			}												
			if(email.length()==0)
			{
				list1.add("Enter Email Field");
			}
			if(!list1.isEmpty())
			{
				request.setAttribute("errors", list1);
				RequestDispatcher rd2=request.getRequestDispatcher("Addplayer");
				rd2.forward(request, response);
				
			}Player p=new Player(name, age, district, position, email, istrm);
			View V=new View();
			V.StoreData(p);
		request.setAttribute("msg", msg);
		getServletContext().getRequestDispatcher("/Acknowledgement.html").forward(request, response);
	
		
		}
}