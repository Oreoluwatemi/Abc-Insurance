package mvc.models;

public class InputValidation {
	
	public String checkLoginInput(String email, String password) {
		String error = "";
		if(email.isEmpty()) {
			error += "Email is required <br/>";
		}
		if(password.isEmpty()) {
			error += "Password is required <br/>";
		}
		return error;
	}
	public String checkAdminLoginInput(String username, String password) {
		String error = "";
		if(username.isEmpty()) {
			error += "Username is required <br/>";
		}
		if(password.isEmpty()) {
			error += "Password is required <br/>";
		}
		return error;
	}
	
	public String checkProductInput(String name, String model) {
		String error = "";
		if(name.isEmpty()) {
			error += "Product name is required <br/>";
		}
		if(model.isEmpty()) {
			error += "Model is required <br/>";
		}
		return error;
	}
	
	public String checkRegisterInput(String username, String email, String phoneno, String address, String password, String cpassword) {
		String error = "";
		if(email.isEmpty()) {
			error += "Email is required <br/>";
		}
		if(password.isEmpty()) {
			error += "Password is required <br/>";
		}
		if(cpassword.isEmpty()) {
			error += "Confirm Password is required <br/>";
		}
		if(username.isEmpty()) {
			error += "Username is required <br/>";
		}
		if(phoneno.isEmpty()) {
			error += "Phone number is required <br/>";
		}
		if(address.isEmpty()) {
			error += "Address is required <br/>";
		}
		if(!password.isEmpty() && !cpassword.isEmpty() && !cpassword.equals(password)) {
			error += "Password and Confirm Password not matching <br/>";
		}
		
		return error;
	}

}
