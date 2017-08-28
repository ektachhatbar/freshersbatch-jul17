package com.java.servlets;

import java.util.*;
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

public class ControllerServlet extends HttpServlet{
	ServletContext ctx;
	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String strForward=request.getParameter("forward");
		HttpSession session=request.getSession(true);
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		if("authenticate".equals(strForward)){
			rd=this.ctx.getRequestDispatcher("/login");
		}else if("compbooks".equals(strForward)){
			rd=this.ctx.getRequestDispatcher("/compbooks");
		}else if("histbooks".equals(strForward)){
			List<String> cbooks=new ArrayList<String>();
			String books[]=request.getParameterValues("box");
			for(int i=0;i<books.length;i++){
				cbooks.add(books[i]);
			}
			System.out.println("Book "+cbooks);
			rd=this.ctx.getRequestDispatcher("/histbooks");
			session.setAttribute("cbooks", cbooks);
			
		}else if("shoppingcart".equals(strForward)){
			List<String> hbooks=new ArrayList<String>();
			String books[]=request.getParameterValues("hb");
			for(int i=0;i<books.length;i++){
				hbooks.add(books[i]);
			}			
			System.out.println("HBook "+books);
			rd=this.ctx.getRequestDispatcher("/shoppingcart");
			session.setAttribute("hbooks", hbooks);
		}else if("logout".equals(strForward)){
			rd=this.ctx.getRequestDispatcher("/logout");
		}else{
			out.println("<html><body><h1>Login Failed :(</h1></body></html>");
		}
		rd.forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		doGet(request,response);
	}
}
