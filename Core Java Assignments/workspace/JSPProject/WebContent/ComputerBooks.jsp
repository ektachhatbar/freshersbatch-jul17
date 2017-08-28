<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome <%=session.getAttribute("uname")%></h1>
	<form action="ControllerServlet?forward=HistoryBooks" method="post">
		<input type="checkbox" name="box" value="C"> C<br> 
		<input type="checkbox" name="box" value="C++"> C++<br> 
		<input type="checkbox" name="box" value="JAVA"> JAVA<br> 
		<input type="submit" value="Next">
	</form>
</body>
</html>