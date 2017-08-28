package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CompBooksServlet extends HttpServlet{
	ServletContext ctx;

	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String uname=(String)session.getAttribute("username");
		out.println("<html><body><h1>Welcome "+uname+
				"</h1><form action='controller?forward=histbooks' method='post'>"
				+ "<input type='checkbox' name='box' value='C'> C<br>"
				+ "<input type='checkbox' name='box' value='C++'> C++<br>"
				+ "<input type='checkbox' name='box' value='JAVA'> JAVA<br>"
				+ "<input type='submit' value='Next'></form></body></html>");
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		doGet(request,response);
	}
}
