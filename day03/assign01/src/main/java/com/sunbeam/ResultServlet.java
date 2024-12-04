package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet{
	private ArrayList<Marks>result;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	processRequest(req, resp);
}

public  void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
	resp.setContentType("text/html");
	
	
	PrintWriter out = resp.getWriter();
	//p capital
	
	
	 out.println("<html>");
     out.println("<head><title>Marks List</title></head>");
     out.println("<body>");
     out.println("<h1>Subject Marks</h1>");
     out.println("<table border='1'>");
     out.println("<tr><th>Subject</th><th>Marks</th></tr>");
     
     
     
	 for(Marks m:result) { 
		    out.println("<tr>"); 
		    out.printf("<td>%s</td>\r\n", m.getSubject()); 
		    out.printf("<td>%f.2</td>\r\n", m.getMarks());
 
	    out.println("</tr>"); 
	} 
	 
	 out.println("</table>");
     out.println("</body>");
     out.println("</html>");
 
	
	
}

@Override
public void init(ServletConfig config) throws ServletException { 
super.init(config); 
   result = new ArrayList<>(); 
   result.add(new Marks("Java programming", 80.0)); 
   result.add(new Marks("Web programming", 85.0)); 
   result.add(new Marks("Database technologies", 83.0));
} 
}


