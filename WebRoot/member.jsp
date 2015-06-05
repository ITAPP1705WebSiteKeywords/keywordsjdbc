<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="common.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
    	HttpSession usersession = request.getSession();
    	
    	if(usersession.getAttribute("username")==null){
    			response.sendRedirect("login.jsp");
    	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	

  </head>
  
  <body>
  
  <jsp:include page="menubar.jsp"></jsp:include>
  
   
    <div>
    	<form name="uploadform" action="UploadServlet" method="post" enctype="multipart/form-data">
    		<table>
    			<tr>
    				<td>Upload file:</td>
    				<td><input type="file" name="file" size="50"></td>
    				<td><input type="submit" name="submit"  value="Upload"></td><td><input type="reset" value="Reset"></td>
    			</tr>
    		</table>
    	</form>
    </div>
    <div >
    <jsp:include page="files.jsp"></jsp:include>
    
    	
    
     
    
    </div>
  </body>
</html>
