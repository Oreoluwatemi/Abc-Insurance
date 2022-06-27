package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProduct {
	Connection conn;
	int rs;
	public AddProduct() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean createProduct(String name, String model) throws Exception {
		String sql = "insert into product values (NULL,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2, model);
		
		int c = st.executeUpdate();
		if(c == 1)
		return true;
		else
		return false;
		
	}
	public boolean editProduct(int id, String model) throws Exception {
		String sql = "update product set productmodel=? where id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, model);
		st.setInt(2, id);
		
		int c = st.executeUpdate();
		if(c == 1)
		return true;
		else
		return false;
		
	}
}
