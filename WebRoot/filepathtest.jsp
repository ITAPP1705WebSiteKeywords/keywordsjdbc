<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.servlet.ServletConfig"%>
<%@ page import="common.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String realPath = request.getContextPath();
ServletConfig sconfig = this.getServletConfig();
String rootPath = sconfig.getServletContext().getRealPath("/");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'filepathtest.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    <%= rootPath %>
    <%
    	String replace = rootPath.replaceAll("\\\\", "\\\\\\\\");
     %>
     <%= replace %>
    <%
    	PrintWriter output = response.getWriter();
    	String file_name = request.getParameter("filename");
    	out.println("<br>"+file_name+"<br>");
    	
    	String file_path = "";
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "select filepath from t_files where filename='"+file_name+"'";
			db.query(sql);
			if(db.next()) {
				try{
				file_path = db.getRs().getString("filepath");
				}catch(Exception e){}
			}
			}
		out.println(file_path);
		out.println("to the end!");
     %>
  </body>
</html>
