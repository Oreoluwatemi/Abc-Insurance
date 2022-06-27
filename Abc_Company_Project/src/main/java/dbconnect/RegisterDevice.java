package dbconnect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDevice {

	Connection conn;
	int rs;
	public RegisterDevice() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean regDevice(String username, String prodname, String serialno, Date date) throws Exception {
		String sql = "insert into register_product values (NULL,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, prodname);
		st.setString(3, serialno);
		st.setDate(4, date);
		
		
		int c = st.executeUpdate();
		if(c == 1)
		return true;
		else
		return false;
		
	}

}
