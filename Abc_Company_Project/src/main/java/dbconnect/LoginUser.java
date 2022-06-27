package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.models.User;

public class LoginUser {
	Connection conn;
	ResultSet rs;
	User user;
	public LoginUser() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User getUser(String email, String password) throws Exception {
		
		String sql = "select * from user where email=? and password=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, email);
		st.setString(2, password);
		
		this.rs = st.executeQuery();
			
		while(this.rs.next()) {
			this.user = new User(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3),
					this.rs.getString(4), this.rs.getString(5),this.rs.getString(6));
		}
		return this.user;
		
	}
}
