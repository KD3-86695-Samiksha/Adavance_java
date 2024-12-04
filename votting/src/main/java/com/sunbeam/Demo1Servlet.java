package com.sunbeam;

import javax.servlet.http.HttpServlet;

public class Demo1Servlet extends HttpServlet{
	
	
	// calls HttpServlet's init() method
	// it attach given "config" arg to the current servlet object "this".
	// if not called, config.getInitParameter() will work well, but
	// this.getInitParameter() will return null.
	
	
}
