<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		body { TEXT-ALIGN: center; }
		#center { MARGIN-RIGHT: auto; MARGIN-LEFT: auto; }
	
	</style>
	
  </head>
  
  <body>
  <jsp:include page="menubar.jsp"></jsp:include>
  
  <div>
	<form name="form1" action="UserServlet.do?method=login" method="post">
		<table width="200" border="1">
			<tr>
				<td colspan="2">Log in</td>
			</tr>
			<tr>
				<td>User name</td>
				<td><input type="text" name="username" size="15"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" size="15"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" name="submit" value="Log in"></td><td> <a
					href="register.jsp">Register</a></td>
			</tr>
		</table>
		</form>
	</div>
  </body>
</html>
