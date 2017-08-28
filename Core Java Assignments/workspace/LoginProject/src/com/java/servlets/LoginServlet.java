package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(value="/login")
public class LoginServlet extends HttpServlet{
	ServletContext ctx;
	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd=null;
		HttpSession session=request.getSession(true);
		if(session.isNew()){
			String userName=request.getParameter("uname");
			String pwd=request.getParameter("password");
			if(userName.equals(pwd)){
				session.setAttribute("username", userName);
				rd=this.ctx.getRequestDispatcher("/controller?forward=compbooks");
				rd.forward(request,response);
			}else{
				out.println("<html><body><h1>Login Failed</h1></body></html>");
			}
		}else{
			session.invalidate();
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		doGet(request,response);
	}
}
