package mvc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.LoginAdmin;
import dbconnect.LoginUser;
import mvc.models.Admin;
import mvc.models.InputValidation;
import mvc.models.User;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 		InputValidation errorMessage = new InputValidation();
 		String error = errorMessage.checkAdminLoginInput(username, password);
		Admin result;
		try {
			
			if(error.isEmpty()) {
				LoginAdmin user = new LoginAdmin();
				result = user.getUser(username, password);
			if (result.getUsername() != null) {
				rd = request.getRequestDispatcher("/adminindex.jsp");
				
				request.setAttribute("admin", result);
		
			}else {
				error += "Username/Password Invalid <br/>";
				request.setAttribute("error", error);
				rd = request.getRequestDispatcher("/adminlogin.jsp");
			}
			}
			else {
				request.setAttribute("error", error);
				rd = request.getRequestDispatcher("/adminlogin.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
