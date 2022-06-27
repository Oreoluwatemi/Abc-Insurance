package mvc.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnect.GetData;

public class ValidateClaim {
	public int count = 0;
	
	public int checkClaimValidity(String username, String prodname) {
		try {
			GetData allclaims = new GetData();
			ArrayList<Claim> claim = allclaims.getAllClaim();
			
			for(int i = 0; i < claim.size(); i++) {
				if(claim.get(i).getUsername().equals(username)) {
					if(claim.get(i).getProductname().equals(prodname)) {
						this.count++;						
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return this.count;
	}
	
}
