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
 * Servlet implementation class NameAgeServlet
 */
@WebServlet("/NameAgeServlet")
public class NameAgeServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public NameAgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		//Prepare the response writer
			
		PrintWriter pw=response.getWriter();
		
		
		//Deal with the request parameters
		// http://localhost:8080/NameAgeServlet?name=Zartab&age=30
		
		String name=request.getParameter("name");
		String ageS=request.getParameter("age");
		int age=Integer.parseInt(ageS);
		
		
		
		
		//Respond back using response object
		
		pw.println("<html><body>");
		pw.println("Hello "+name+"!! You are "+age+" years old<br>");
		pw.println("Next Year you will be "+(age+1)+" years old!!");
		pw.println("</body></html>");
		
		
	}

}
