package com.servlets;

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

import javabeans.BookBean;
import javabeans.LoginBean;

public class ControllerServlet extends HttpServlet {
	ServletContext ctx;

	public void init(ServletConfig config) throws ServletException {
		this.ctx = config.getServletContext();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String strForward = request.getParameter("forward");
		HttpSession session = request.getSession(true);

		if ("login".equals(strForward)) {
			LoginBean loginBean = new LoginBean(request.getParameter("uname"), request.getParameter("password"));
			boolean result = loginBean.login();
			if (result) {
				session.setAttribute("uname", request.getParameter("uname"));
				rd = this.ctx.getRequestDispatcher("/ComputerBooks.jsp");
			} else {
				rd = this.ctx.getRequestDispatcher("/login.jsp");
			}
		} else if ("HistoryBooks".equals(strForward)) {
			BookBean bookBean = new BookBean();
			bookBean.addBook(request.getParameterValues("box"));
			session.setAttribute("cbooks", bookBean);
			rd = this.ctx.getRequestDispatcher("/HistoryBooks.jsp");
			
		}else if ("ShoppingCart".equals(strForward)) {
			BookBean bookBean = new BookBean();
			bookBean.addBook(request.getParameterValues("hb"));
			session.setAttribute("hbooks", bookBean);
			rd = this.ctx.getRequestDispatcher("/ShoppingCart.jsp");
		}else if ("logout".equals(strForward)) {
			session.invalidate();
			rd = this.ctx.getRequestDispatcher("/login.jsp");
		}else {
			rd = this.ctx.getRequestDispatcher("/login.jsp");
		}
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
