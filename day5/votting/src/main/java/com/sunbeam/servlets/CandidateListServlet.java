package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet {
//HttpServlet:handle http request for example doGet() etc
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProcessRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProcessRequest(req, resp);
	}

	protected void ProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list = new ArrayList<>();
		// get candidate list from db
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		// display list in html form as radio buttons
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		//PrintWriter is used to write the HTML content back to the client.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		// get app title from ctx param and display it
		ServletContext cl = this.getServletContext();
		String color= cl.getInitParameter("background-color");
		//out.printf("<background color>", appTitle);
		out.printf("<body bgcolor=%s>",color);
		
		
		

		// get app title from ctx param and display it
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		
		
		//cookies codebelow
		// get user name and role from cookie and display it
				Cookie[] arr = req.getCookies();
				String userName = "", role = "";
				if(arr != null) {
					for (Cookie c : arr) {
						if(c.getName().equals("uname"))
							userName = c.getValue();
						if(c.getName().equals("role"))
							role = c.getValue();
					}
				}
				out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		

				// get servlet context and retrieve announcement from it and display
				ServletContext ctx = this.getServletContext();
				String ann = (String) ctx.getAttribute("announcement");
				if(ann != null)
					out.println("<p style='color:red'> NOTE: " + ann + "</p>");
				

				
		//above cookies
		
		out.println("<h2>Candidate List</h2>");
		out.println("<form method='post' action='vote'>");
		for(Candidate c : list) {
			out.printf("<input type='radio' name='candidate' value='%d'/> %s <br/>\n", 
					c.getId(), c.getName());
		}
		out.println("<br/><input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
}
