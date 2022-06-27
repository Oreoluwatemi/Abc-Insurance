package dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.models.Claim;
import mvc.models.Product;
import mvc.models.RegisteredDevice;
import mvc.models.User;

public class GetData {

	Connection conn;
	ResultSet rs;
	Product prod;
	User user;
	RegisteredDevice device;
	Claim claim;
	public GetData() throws ClassNotFoundException, SQLException {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User getUser(String username) {
		String sql = "select * from user where username=?";
		try {
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, username);
		this.rs = st.executeQuery();
		
		while(this.rs.next()) {
			user = new User(this.rs.getInt(1),this.rs.getString(2), this.rs.getString(3),
					this.rs.getString(4), this.rs.getString(5),this.rs.getString(6));
			return user;
		}
		}catch(Exception e) {
			return user = null;
		}
		
		return user;
	}
	
public ArrayList<Product> getAllProducts() throws Exception {
		
		String sql = "select * from product";
		PreparedStatement st = conn.prepareStatement(sql);
		
		this.rs = st.executeQuery();
		ArrayList<Product> products = new ArrayList<Product>();
		while(this.rs.next()) {
			this.prod = new Product(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3));
			products.add(prod);
		}
		return products;
		
	}


public ArrayList<User> getAllUsers() throws Exception {
	
	String sql = "select * from user";
	PreparedStatement st = conn.prepareStatement(sql);
	
	this.rs = st.executeQuery();
	ArrayList<User> users = new ArrayList<User>();
	while(this.rs.next()) {
		this.user = new User(this.rs.getInt(1),this.rs.getString(2), this.rs.getString(3),
				this.rs.getString(4), this.rs.getString(5),this.rs.getString(6));
		users.add(user);
	}
	return users;
	
}

public ArrayList<RegisteredDevice> getAllRegisteredDevice() throws Exception {
	
	String sql = "select * from register_product";
	PreparedStatement st = conn.prepareStatement(sql);
	
	this.rs = st.executeQuery();
	ArrayList<RegisteredDevice> devices = new ArrayList<RegisteredDevice>();
	while(this.rs.next()) {
		this.device = new RegisteredDevice(this.rs.getInt(1),this.rs.getString(2), this.rs.getString(3),
				this.rs.getString(4), this.rs.getDate(5));
		devices.add(device);
	}
	return devices;
	
}

public ArrayList<Claim> getAllClaim() throws Exception {
	
	String sql = "select * from claim";
	PreparedStatement st = conn.prepareStatement(sql);
	
	this.rs = st.executeQuery();
	ArrayList<Claim> claims = new ArrayList<Claim>();
	while(this.rs.next()) {
		this.claim = new Claim(this.rs.getInt(1),this.rs.getDate(2), this.rs.getString(3),
				this.rs.getString(4), this.rs.getString(5), this.rs.getString(6));
		claims.add(claim);
		
	}
	return claims;
	
}


}
