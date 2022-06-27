package mvc.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.EnterClaim;
import dbconnect.GetData;
import dbconnect.RegisterUser;
import mvc.models.Claim;
import mvc.models.RegisteredDevice;
import mvc.models.User;
import mvc.models.ValidateClaim;

/**
 * Servlet implementation class ClaimController
 */
@WebServlet("/ClaimController")
public class ClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClaimController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String prodname = request.getParameter("productname");
		String desc = request.getParameter("desc");
		long millis=System.currentTimeMillis();
		Date date = new Date(millis);
		String status = "Pending";
		RequestDispatcher rd = null;
 		
		boolean result;
		try {
			ValidateClaim validate = new ValidateClaim();
			int count = validate.checkClaimValidity(username, prodname);
			if(count >= 3) {
				rd = request.getRequestDispatcher("/error.jsp");
			}
			else {
			EnterClaim enterClaim = new EnterClaim();
			result = enterClaim.regClaim(date, desc, username, prodname, status);
			if (result) {
				rd = request.getRequestDispatcher("/selectdevice.jsp");
				Claim claim = new Claim(date, desc, username, prodname, status);
				GetData data = new GetData();
				ArrayList<RegisteredDevice> devices = data.getAllRegisteredDevice();
				request.setAttribute("devicelist", devices);
				request.setAttribute("claim", claim);
				request.setAttribute("user", username);
			} else {
				rd = request.getRequestDispatcher("/error.jsp");
			}
			}
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
