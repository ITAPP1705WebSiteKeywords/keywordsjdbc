<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="common.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'files.jsp' starting page</title>
    
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
    
   <% 
    	PrintWriter output = response.getWriter(); 
    	HttpSession filesession = request.getSession();
    	ResultSet fileRs = null;
    	if(filesession.getAttribute("listfiles")!=null){
    		 fileRs = (ResultSet)filesession.getAttribute("listfiles");
    	}
    	else{
    		DBAccess db = new DBAccess();
			if(db.createConn()) {
				String sql = "select * from t_files";
				db.query(sql);
			}
			fileRs = db.getRs();
    	
    	}
    	int count = 1;
	    while(fileRs.next()){
			    	   
			    	   String listfilename = fileRs.getString("filename");
			    	   String filePath = fileRs.getString("filepath");
			    	   String keywordsAuto = " keywords1  keywords2  keywords3";
			    	   if(fileRs.getString("keywords_auto")!=null){
			    	   keywordsAuto = fileRs.getString("keywords_auto");
			    	   }
			    	   output.println("<table><tr><td>"+count+"</td><td>"+listfilename+"</td><td><a href=\"DeleteServlet?filename="
			    	   +listfilename+"\">Delete</a></td><td><a href=\"DownloadServlet?filename="+listfilename
			    	   +"\">Download</a></td></tr><tr><td>File path:</td><td>"+filePath+"</td></tr><tr><td>Keywords:  </td><td>"+keywordsAuto+"</td></tr></table>");
			    	   
			    	   
			    	   output.println("<br>");
			    	   count = count+1;
		}
		
    
    %>	
    
    
  </body>
</html>
