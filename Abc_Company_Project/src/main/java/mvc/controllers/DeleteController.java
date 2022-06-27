package mvc.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.DeleteUser;
import dbconnect.GetData;
import dbconnect.LoginUser;
import mvc.models.InputValidation;
import mvc.models.Product;
import mvc.models.User;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
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
		String reqId = request.getParameter("id");
		String role = request.getParameter("role");
		RequestDispatcher rd = null;
 		
		int result;
		try {
			int id = Integer.parseInt(reqId);
			DeleteUser user = new DeleteUser();
			result = user.deleteUser(id);
			
			if(role.equals("user")) {
				rd = request.getRequestDispatcher("/register.jsp");
			}
			if(role.equals("admin")) {
				GetData data = new GetData();
				ArrayList<User> users = data.getAllUsers();
				request.setAttribute("userlist", users);
				rd = request.getRequestDispatcher("/allusers.jsp");
			}
			
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
