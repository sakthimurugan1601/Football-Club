package com.use;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Addplayer")
public class Addplayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Addplayer() {
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
		out.println("<link rel='StyleSheet' href='t.css'>");
		out.println("</head>");
		out.println("<body>");
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
	    out.println("<div class=ps");
	  	out.println("<marquee><h2><i>Register for matches.....!!&#128512</h2><i></marquee>");

	    out.println("<form action='AddplayerController' method='post' enctype='multipart/form-data'>");
	    out.println("Name<input type='text' name='name' required ><br><br>");
	    out.println("Age<input type='text' name='age'><br><br>");
	    out.println("District<input type='text' name='district'><br><br>");
	    out.println("Email<input type='text' name='email'><br><br>");
	    out.println("Position<input type='text' name='position'><br><br>");
	    out.println("Biodata<input type='file' name='biodata'><br><br>");
	    out.println("<input type='submit' name='Submit'><br><br>");
	    out.println("</div>");
		out.println("</center></form></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
