package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
		
		protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// TODO Auto-generated method stub
		
			resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();//used to write html code
		out.println("<html>");
		out.println("<head");
		out.println("<title>Info Resume</title>");
		out.println("</head>");
		out.println("<body  bgcolor='pink'  >");
		out.printf("<h1>FirstName:%s</h1>","samiksha");
         out.printf("<h1>LastName:%s</h1>","kale");
         
         out.printf("<h1>qualification:%s</h1>","gradution");
         out.printf("<h1>collegename:%s</h1>","Hitech");
         out.printf("<h1>birthdate:%s</h1>","22-01-2001");
         
		out.println("</body>");
         out.println("</html>");
		
		
	}
}
