package servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;   
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload; 

import common.*;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;  
	final public void init(ServletConfig config) throws ServletException {  
	  this.config = config; 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		  doGet(request, response);  
	}  
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("filename");
		String filePath = "";
		Boolean flag = false;
		HttpSession session = request.getSession();
		
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "select * from t_files where filename='"+fileName+"'";
			db.query(sql);
			if(db.next()) {
				try{
					filePath = db.getRs().getString("filepath");
					//String ext = db.getRs().getString("type");
					//filePath = "/upload/"+fileName+"."+ext;
				}catch(Exception e){}
			}
			if(filePath!=""){
				File file = new File(filePath);
				if(file.exists()&&file.isFile()){
					flag = file.delete();
				}
			}
			if(flag){
				String deleteSql = "delete from t_files where filename='"+fileName+"'";
				db.update(deleteSql);
				
				String aftersql = "select * from t_files";
				db.query(aftersql);
				
				ResultSet rs = db.getRs();
				session.setAttribute("listfiles", rs);
				
				
			}
		}
		
	       
	    response.sendRedirect("member.jsp");
		
		
	}
	
	
	
}
