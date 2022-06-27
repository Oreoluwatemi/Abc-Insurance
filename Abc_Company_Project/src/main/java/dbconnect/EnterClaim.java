package dbconnect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnterClaim {
	Connection conn;
	int rs;
	
	public EnterClaim() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean regClaim(Date date, String description, String username, String productname, String status) throws Exception {
		String sql = "insert into claim values (NULL,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setDate(1, date);
		st.setString(2, description);
		st.setString(3, username);
		st.setString(4, productname);
		st.setString(5, status);
		
		
		int c = st.executeUpdate();
		if(c == 1)
		return true;
		else
		return false;
		
	}
	
	public boolean updateClaim(int id, String status) throws Exception {
		String sql = "update claim set status=? where id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, status);
		st.setInt(2, id);
		
		
		int c = st.executeUpdate();
		if(c == 1)
		return true;
		else
		return false;
		
	}

}
