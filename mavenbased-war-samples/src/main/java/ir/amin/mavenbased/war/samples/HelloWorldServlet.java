package ir.amin.mavenbased.war.samples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ir.amin.mavenbased.ejb.samples.Hello;

public class HelloWorldServlet extends HttpServlet {

	@EJB
	private Hello hello;
	
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Welcome ";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		Enumeration<String> headerNames = request.getHeaderNames();
		ArrayList<String> headerNamesList = Collections.list(headerNames);
		for (String headerName : headerNamesList) {			
			out.println(headerName + " : " +request.getHeader(headerName) + "<br />");
		}
        
		
		out.println("<h1>" + message + hello.sayHello() + " "+name+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy() {
		// do nothing.
	}
}
