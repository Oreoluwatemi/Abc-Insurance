package mvc.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.GetData;
import mvc.models.Claim;
import mvc.models.Product;
import mvc.models.RegisteredDevice;
import mvc.models.User;

/**
 * Servlet implementation class UserDetailsController
 */
@WebServlet("/UserDetailsController")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			GetData data = new GetData();
			ArrayList<RegisteredDevice> devices = data.getAllRegisteredDevice();
			ArrayList<Claim> claims = data.getAllClaim();
			RequestDispatcher rd = null;
			
			String name = request.getParameter("name");

			
			
			rd = request.getRequestDispatcher("/userdetails.jsp");
				
			request.setAttribute("devicelist", devices);
			request.setAttribute("claimlist", claims);
			request.setAttribute("user", name);
			
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
