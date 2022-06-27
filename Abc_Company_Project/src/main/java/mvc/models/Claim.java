package mvc.models;

import java.sql.Date;

public class Claim {
	private int id;
	private Date claimdate;
	private String description;
	private String username;
	private String productname;
	private String status;
	
	public Claim(int id, Date claimdate, String  description, String username, String productname,String status) {
		
		this.id = id;
		this.username = username;
		this.productname = productname;
		this.description = description;
		this.claimdate = claimdate;
		this.status = status;
	}
	
public Claim(Date claimdate, String  description, String username, String productname,String status) {
		
		this.username = username;
		this.productname = productname;
		this.description = description;
		this.claimdate = claimdate;
		this.status = status;
	}

public Claim() {
	
	this.id = 0;
	this.username = "";
	this.productname = "";
	this.description = "";
	this.claimdate = null;
	this.status = "";
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getClaimdate() {
	return claimdate;
}

public void setClaimdate(Date claimdate) {
	this.claimdate = claimdate;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
}
