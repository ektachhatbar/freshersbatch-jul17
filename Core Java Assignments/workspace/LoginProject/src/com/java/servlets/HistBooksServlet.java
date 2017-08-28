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

public class HistBooksServlet extends HttpServlet{
	ServletContext ctx;

	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		HttpSession session=request.getSession(true);
		String uname=(String)session.getAttribute("username");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>Welcome "+uname+
				"</h1><form action='controller?forward=shoppingcart' method='post'>"
				+ "<input type='checkbox' name='hb' value='HB1'> HB 1<br>"
				+ "<input type='checkbox' name='hb' value='HB2'> HB 2<br>"
				+ "<input type='checkbox' name='hb' value='HB3'> HB 3<br>"
				+ "<input type='submit' value='Show'></form></body></html>");
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		doGet(request,response);
	}
}
