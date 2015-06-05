<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>menu.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
     <!--  <link rel="stylesheet" type="text/css" href="css/menubar.css" /> -->
     <style type="text/css">
		*{
		  
		  list-style:none;
		}
		body{text-align:center;}
		div{margin:0 auto;}
		li{
		  float:left;
		  font-size:14px;
		}
		a{
		  float:left;
		  border:1px solid #000;
		  padding:5px 10px;
		  text-decoration:none;
		  color:#000;
		}
	
		ul{
		  display:inline-block;
		  *display:inline;
		  zoom:1;
		}
</style>


  </head>
  
  <body>
  	<%
  		PrintWriter output = response.getWriter(); 
    	HttpSession usersession = request.getSession();
    	String inorout = "in";
    	String action = "login.jsp";
	   
	    if(usersession.getAttribute("username")!=null){
	    	inorout = "out";
		}
		
		if(inorout=="out"){
			action = "UserServlet.do?method=logout";
		}

	    
	    
	    
	   
	    
	    	
	    
  	 %>
    
     <div id="nav">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="search.jsp">Search</a></li>
                <li><a href="member.jsp">Member</a></li>
                <li><a href="<%=action %>">Log <%=inorout%></a></li>
                <li><a href="register.jsp">Register</a></li>
                
            </ul>
        </div>
  </body>
</html>