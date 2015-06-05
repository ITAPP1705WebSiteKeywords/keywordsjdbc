package servlet;


import java.io.IOException;  
import java.io.PrintWriter; 

import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  



import java.sql.ResultSet;



import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload; 

import common.*;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;  
	final public void init(ServletConfig config) throws ServletException {  
	  this.config = config; 
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		//PrintWriter out = response.getWriter(); 
		SmartUpload su = new SmartUpload();  
		String fileName = request.getParameter("filename");
		String filePath = "";
		/*FileBean downfile = new FileBean();
		if(downfile.isExist("fileName")){
			filePath = downfile.getFilepath("fileName");
		}*/
		
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "select * from t_files where filename='"+fileName+"'";
			db.query(sql);
			if(db.next()) {
				try{
					//filePath = db.getRs().getString("filepath");
					String ext = db.getRs().getString("type");
					filePath = "/upload/"+fileName+"."+ext;
				}catch(Exception e){}
			}
			}
		
		su.initialize(config,request,response);
		su.setContentDisposition(null);
		try {
			       su.downloadFile(filePath);
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		  doGet(request, response);  
		 }  
}
