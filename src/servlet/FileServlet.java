package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;

import com.jspsmart.upload.*;



public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;  
	final public void init(ServletConfig config) throws ServletException {  
	  this.config = config; 
	 }  

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = (String)request.getParameter("method");
		if(method==null) {
			PrintWriter out = response.getWriter();
			out.println("invalid request!");
		} else if(method.equals("upload")) {
			Upload(request, response);
		} else if(method.equals("dowonload")) {
			Download(request, response);
		} else if(method.equals("delete")) {
			Delete(request, response);
		}
	}
	
	protected void Upload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//String filename = request.getParameter("filename");
		//String filepath = request.getParameter("filepath");
		 PrintWriter out = response.getWriter();
		
		try{
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(),request,response);
    	//String str = request.getSession().getServletContext().getRealPath("/");
    	//System.out.println(str);
    	su.upload();
    	su.save("/upload");
    	//response.sendRedirect("uploadtest.jsp");
    	//out.println("Successfully uploaded!");
		}
		catch(Exception e){
			out.println("Unable to upload the file.<br>");  
		    out.println("Error : " + e.toString()); 
		}
		
		
	}
	
	protected void Download(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {}
	
	protected void Delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {}

}
