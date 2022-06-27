package mvc.models;

import java.sql.Date;

public class RegisteredDevice {

	private int id;
	private String username;
	private String productname;
	private String serialno;
	private Date purchasedate;
	
	public RegisteredDevice(String userid, String  productid, String serialno, Date purchasedate) {
		this.username = userid;
		this.productname = productid;
		this.serialno = serialno;
		this.purchasedate = purchasedate;
	}
	public RegisteredDevice(int id, String userid, String  productid, String serialno, Date purchasedate) {
		this.id = id;
		this.username = userid;
		this.productname = productid;
		this.serialno = serialno;
		this.purchasedate = purchasedate;
	}

	public RegisteredDevice() {
		this.id = 0;
		this.username= "";
		this.productname = "";
		this.serialno = "";
		this.purchasedate = null;
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
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public Date getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	
}
