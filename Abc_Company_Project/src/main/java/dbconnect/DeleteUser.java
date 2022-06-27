package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.models.User;

public class DeleteUser {
	Connection conn;
	int rs;
	User user;
	public DeleteUser() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int deleteUser(int id) throws Exception {
		
		String sql = "delete from user where id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		
		this.rs = st.executeUpdate();
			
		return this.rs;
	}
}
