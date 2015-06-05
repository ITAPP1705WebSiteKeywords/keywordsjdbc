package common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FileBean {
	private String user;
	private String filename;
	private String filepath;
	private int    size;
	private String type;
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FileBean(){}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}
	
	

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isExist(String filename) {
		boolean isExist = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "select * from t_files where filename='"+filename+"'";
			db.query(sql);
			if(db.next()) {
				isExist = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isExist;
	}
	
	public void addfile(String user, String filename, String filepath,byte[] content, int size,String type) {
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "insert into t_files(user,filename,filepath,filecontent,size,type) values('"+user+"','"+
		   			filename+"','"+filepath+"','"+content+"',"+size+",'"+type+"')";
			db.update(sql);
			db.closeStm();
			db.closeConn();
		}
	}
	
	

}
