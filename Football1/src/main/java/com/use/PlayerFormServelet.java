package com.use;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/PlayerFormServelet")
public class PlayerFormServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PlayerFormServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='StyleSheet' href='k.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='ps'>");
		out.println("<marquee><h2><i>Players List info.....!!&#128512</h2><i></marquee>");
		out.println("<hr>");
		out.println("<center>");
		out.println("<table border ='1'><th>Name</th><th>Age</th><th>District</th><th>Email</th><th>Position</th><th>Biodata</th>");
		out.println("</div>");
		
		out.println("</center>");
		ResultSet rs=new View().RetrievePlayer();
		try {
			while(rs.next()) {
				out.println("<tr><th>"+rs.getString("Name")+"</th><th>"+rs.getInt("age")+"</th><th>"+rs.getString("District")+"</th><th>"+rs.getString("Email")+"</th><th>"+rs.getString("Position")+"</th><th>"+rs.getBlob("Biodata")+"</th></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
