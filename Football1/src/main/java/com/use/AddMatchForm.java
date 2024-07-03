package com.use;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMatchForm")
public class AddMatchForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddMatchForm() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList <String> list=(ArrayList<String>) request.getAttribute("errors");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='StyleSheet' href='u.css'>");
		out.println("</head>");
		out.println("<body>");
		if(list !=null)
		{
			Iterator <String>itr=list.iterator();
			out.println("<ul>");
			while(itr.hasNext())
			{
				out.println("<li>"+itr.next()+"</li>");	
			}
			out.println("</ul>");
		}
		 out.println("<div class='ps'>");
	    out.println("<h2>Add Match Details !!!</h2>");
	    out.println("<form action='AddMatchController' method='post'>");
	    out.println("<input type='text' name='title'placeholder='Title'required><br><br>");
	    out.println("<input type='text' name='place'placeholder='Place'required><br><br>");
	    out.println("<input type='date' name='date'placeholder='Match Date'required><br><br>");
	    out.println("<input type='submit' name='Submit'class='btn'required><br><br>");
		out.println("</form></body></html>");
		out.println("</div>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}