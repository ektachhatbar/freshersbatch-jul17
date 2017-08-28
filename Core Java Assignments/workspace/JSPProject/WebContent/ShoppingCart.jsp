<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,javabeans.BookBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome <%=session.getAttribute("uname")%> <br> Shopping Cart</h1>
	<br>
	<br>
	<br>
	<%! BookBean bbean;
	List<String> list;%>
	<% 
	bbean=(BookBean)session.getAttribute("cbooks");
		list=bbean.getBook();
		for(String s:list){%>
		<%=s %><br>
		<%}bbean=(BookBean)session.getAttribute("hbooks");
		list=bbean.getBook();
		for(String s:list){%>
		<%=s %><br>
		<%} %>
	<form action='ControllerServlet?forward=logout' method='post'>
		<br><br><input type='submit' value='Logout'>
	</form>
</body>
</html>