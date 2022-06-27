package mvc.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.EnterClaim;
import dbconnect.GetData;
import mvc.models.Claim;
import mvc.models.RegisteredDevice;
import mvc.models.ValidateClaim;

/**
 * Servlet implementation class UpdateClaimController
 */
@WebServlet("/UpdateClaimController")
public class UpdateClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClaimController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		int claimId = Integer.parseInt(id);
		RequestDispatcher rd = null;
 		
		boolean result;
		try {
		
			EnterClaim updateClaim = new EnterClaim();
			result = updateClaim.updateClaim(claimId, status);
			if (result) {
				rd = request.getRequestDispatcher("/allclaims.jsp");
				GetData data = new GetData();
				ArrayList<Claim> claims = data.getAllClaim();
				request.setAttribute("claimlist", claims);
				
			} else {
				rd = request.getRequestDispatcher("/error.jsp");
			}

			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
