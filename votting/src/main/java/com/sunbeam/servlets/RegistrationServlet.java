package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/register")
public class RegistrationServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) {

		String firstName=req.getParameter("firstname");
		String LastName=req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String Dob=req.getParameter("dob");
		String role="voter";
		
		try {
			User u=new User();
			Date d=Date.valueOf(Dob);
			
			u.setFirstName(firstName);
			u.setLastName(LastName);
			u.setEmail(email);
			u.setPassword(password);
	        u.setRole(role);
	        u.setStatus(0);
	       u.setBirth(d);
	        UserDaoImpl u1=new UserDaoImpl();
	        u1.save(u);
	        resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>data Saved Successfully</h2>");
			out.println("<p>\r\n"
					+ "			<a href=\"index.html\">Log In</a>\r\n"
					+ "		</p>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}