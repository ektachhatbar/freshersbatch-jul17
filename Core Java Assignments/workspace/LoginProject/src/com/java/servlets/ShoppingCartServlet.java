package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartServlet extends HttpServlet{
	ServletContext ctx;

	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		HttpSession session=request.getSession(true);
		String uname=(String)session.getAttribute("username");
		List<String> cb=(ArrayList)session.getAttribute("cbooks");
		List<String> hb=(ArrayList)session.getAttribute("hbooks");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>Welcome "+uname+
				" Shopping Cart</h1><br><br>Computer Books : "+cb+" <br>History Books : "+hb+"<br><br><form action='controller?forward=logout' method='post'><input type='submit' value='Logout'></form></body></html>");
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		doGet(request,response);
	}
}
