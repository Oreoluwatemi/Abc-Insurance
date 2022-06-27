package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegisterUser {
	Connection conn;
	int rs;
	public RegisterUser() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean createUser(String username, String email, String phoneno, String address, String password) throws Exception {
		String sql = "insert into user values (NULL,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, email);
		st.setString(3, phoneno);
		st.setString(4, address);
		st.setString(5, password);
		
		int c = st.executeUpdate();
		if(c == 1)
		return true;
		else
		return false;
		
	}

}
