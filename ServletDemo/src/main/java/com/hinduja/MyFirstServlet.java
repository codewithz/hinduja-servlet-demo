package com.hinduja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyFirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// Setting up the response Writer
		PrintWriter pw;
		pw=response.getWriter();
		
		//Deal with incoming request parameters
		
		
		//Send the response
		
		pw.println("<html><body>");
		pw.println("<h1> Hello World from Hinduja College </h1>");
		pw.println("<b>"+new java.util.Date()+"</b>");
		pw.println("</body></html>");
		
		
		
		
		
	}

}
