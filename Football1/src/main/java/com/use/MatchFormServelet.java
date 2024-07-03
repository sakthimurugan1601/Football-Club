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

@WebServlet("/MatchFormServelet")
public class MatchFormServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MatchFormServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='StyleSheet' href='J.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=ps>");
		
		out.println("<marquee><h2>Upcoming Matches info.......&#128512</h2></marquee>");
		out.println("<hr>");
		out.println("<center>");
		out.println("<table border ='1'><th>title</th><th>place</th><th>matchdate</th>");
		out.println("</div>");
		
		out.println("</center>");
		ResultSet rs=new MatchDao().RetrieveMatch();
		try {
			while(rs.next()) {
				out.println("<tr><th>"+rs.getString("title")+"</th><th>"+rs.getString("place")+"</th><th>"+rs.getString("MatchDate")+"</th></tr>");
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
