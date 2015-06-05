package common;

public class UserBean {

	public boolean valid(String username, String password) {
		boolean isValid = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "select * from t_users where user='"+username+"' and password='"+password+"'";
			db.query(sql);
			if(db.next()) {
				isValid = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isValid;
	}
	
	public boolean isExist(String username) {
		boolean isExist = false;
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "select * from t_users where user='"+username+"'";
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
	
	public void add(String user, String password, String email, String phone) {
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "insert into t_users(user,password,email,phone) values('"+user+"','"+password+"','"+email+"','"+phone+"')";
			db.update(sql);
			db.closeStm();
			db.closeConn();
		}
	}
	
	
	
}
