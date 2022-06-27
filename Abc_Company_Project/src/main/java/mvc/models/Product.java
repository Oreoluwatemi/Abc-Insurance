package mvc.models;

import java.sql.Date;

public class Product {

	private int id;
	private String productname;
	private String productmodel;
	
	
	public Product(String productname, String  productmodel) {
		this.productname = productname;
		this.productmodel = productmodel;
	}
	public Product(int id, String productname, String  productmodel) {
		this.id = id;
		this.productname = productname;
		this.productmodel = productmodel;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product() {
		this.id = 0;
		this.productname = "";
		this.productmodel = "";
	}
	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getProductmodel() {
		return productmodel;
	}


	public void setProductmodel(String productmodel) {
		this.productmodel = productmodel;
	}
}
