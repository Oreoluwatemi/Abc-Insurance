package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.models.Admin;

public class LoginAdmin {
	Connection conn;
	ResultSet rs;
	Admin admin;
	public LoginAdmin() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Admin getUser(String username, String password) throws Exception {
		
		String sql = "select * from admin where username=? and password=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, password);
		
		this.rs = st.executeQuery();
			
		while(this.rs.next()) {
			this.admin = new Admin(this.rs.getString(2), this.rs.getString(3));
		}
		return this.admin;
		
	}
}
