package com.hinduja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.Date;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usernameDB="";
		String passwordDB="";
		String name="";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			String url="jdbc:mysql://localhost:3306/hinduja_2021";
			String usernameMySQL="root";
			String passwordMySQL="admin";
			
			Connection con=DriverManager.getConnection(url,usernameMySQL,passwordMySQL);
			System.out.println("Connection Acquired Successfully");
			
			
			
			String query="Select name,email,password from users where email=? and password=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				usernameDB=rs.getString("email");
				passwordDB=rs.getString("password");
				name=rs.getString("name");
				System.out.println(name);
			}
			
			
		
		
		
		if(username.equals(usernameDB)&&password.equals(passwordDB)) {
			
			session.setAttribute("name",name);
			session.setAttribute("dateLoggedIn",new Date());
			
			response.sendRedirect("LoggedInServlet");
			
		}
		else {
			response.sendRedirect("loginPage.html");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
