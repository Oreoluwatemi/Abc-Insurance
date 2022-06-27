package mvc.models;

public class User {

	private int id;
	private String username;
	private String email;
	private String phoneNumber;
	private String address;
	private String password;
	
	public User(String username, String email, String phoneNumber, String address, String password) {
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
	}
	
	public User(int id, String username, String email, String phoneNumber, String address, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
	}

	public User() {
		this.id = 0;
		this.username = "";
		this.email ="";
		this.phoneNumber = "";
		this.address = "";
		this.password = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
