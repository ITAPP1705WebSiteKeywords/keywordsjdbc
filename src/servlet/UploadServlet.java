package servlet;

import java.io.IOException;  
import java.io.PrintWriter; 
import java.io.File;
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  



import java.sql.ResultSet;



import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload; 

import common.*;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;  
	final public void init(ServletConfig config) throws ServletException {  
	  this.config = config; 
	}
	
	 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {  
		  PrintWriter out = response.getWriter();  
		  out.println("<HTML>");  
		  out.println("<BODY BGCOLOR='white'>");  
		  out.println("<H1>jspSmartUpload : Servlet Sample</H1>");  
		  out.println("<HR>");  
		  // 
		  int count = 0;  
		  //
		  SmartUpload su = new SmartUpload();  
		  try {  
		        //
		        su.initialize(config, request, response);  
		       //
		       su.upload();  
		       //for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {  
		       com.jspsmart.upload.File myfile = su.getFiles().getFile(0);  
		       String filename = "";
		       String fileName = myfile.getFileName(); 
		       int pos = fileName.lastIndexOf(".");
		       filename = fileName.substring(0, pos);
		        //
		       count = su.save("/upload");  
		        //count = mySmartUpload.save(null);  
		       //} 
		        
		       //out.println(count +" "+filename +"  file uploaded."); 
		       HttpSession session = request.getSession();
		       String user = (String)session.getAttribute("username");
		      
		       
		       String ext = myfile.getFileExt();
		       int size = myfile.getSize();
		       byte[] content = new byte[size];
		       for(int i=0;i<size;i++){
		    	   content[i] = myfile.getBinaryData(i);
		       }
		    	   
		      
		       //String filepath = myfile.getFilePathName();
		       
		       //String path = request.getContextPath();
		       String basePath = config.getServletContext().getRealPath("/");
		       
		       
		       //out.println(basePath+"<br>");
		       
		       
		       String replacepath = basePath.replaceAll("\\\\", "\\\\\\\\");
		       //out.println(replacepath+"<br>");
		       
		       String fullpath = replacepath+"upload\\\\"+fileName;
		       
		       FileBean newfile = new FileBean();
		       newfile.addfile(user, filename, fullpath, content, size, ext);
		       
		       //ResultSet rs = newfile.listfile();
		       
		       DBAccess db = new DBAccess();
				if(db.createConn()) {
					String sql = "select * from t_files";
					db.query(sql);
				}
				ResultSet rs = db.getRs();

				//String file_Path = rs.getString("filepath");
		    	   
		       
		       //File file = new File(basePath+"upload\\"+fileName);

		       
		       //session.setAttribute("database", db);
		      
		       ClientBean localClient = new ClientBean();
		       localClient.sendToExtractor(filename);
		       
		      
		       //localClient.sendToExtractor(basePath+"upload\\"+fileName);
		       
		       session.setAttribute("listfiles", rs);
		       response.sendRedirect("member.jsp");
		       
		       //db.closeStm();
		       //db.closeConn();
		       
		       //if(newfile.isExist(filename)){
		    	   //out.println("add to file database succeed!");
		       //}
		       //String sql = "insert into t_files(user,filename,filepath,size,type) values("+user+","+
		    		   			//fullname+","+fullpath+","+size+","+ext+")";
		      // FileBean newfile = new FileBean();
		       //newfile.setFilename("");
		  } catch (Exception e) {  
		       out.println("Unable to upload the file.<br>");  
		       out.println("Error : " + e.toString());  
		  }  
		  // 
		  out.println("</BODY>");  
		  out.println("</HTML>");  
		 }  
		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		  doGet(request, response);  
		 }  
		 
	
	

}
