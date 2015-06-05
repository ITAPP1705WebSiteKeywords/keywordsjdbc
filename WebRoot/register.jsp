<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body >
  <jsp:include page="menubar.jsp"></jsp:include>
  <div>
    <form name="form1" action="UserServlet.do?method=register" method="post" >
		<table width="200" border="1">
		<tr>
			<td colspan="2">Register</td>
		</tr>
		<tr>
			<td>User name</td>
			<td><input type="text" name="username" size="15"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password1" size="15"></td>
		</tr>
		<tr>
			<td>Confirm password</td>
			<td><input type="password" name="password2" size="15"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" size="15"></td>
		</tr>
		<tr>
			<td>Phone</td>
			<td><input type="text" name="phone" size="15"></td>
		</tr>
		<tr>
			<td colspan="1"><input type="submit" name="submit" value="Log in"></td><td> <a
				href="login.jsp">return</a></td>
		</tr>
		</table>
	</form>
	</div>
  </body>
</html>
