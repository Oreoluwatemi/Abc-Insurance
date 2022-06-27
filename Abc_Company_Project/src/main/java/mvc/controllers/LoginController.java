package mvc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.LoginUser;
import dbconnect.RegisterUser;
import mvc.models.InputValidation;
import mvc.models.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 		InputValidation errorMessage = new InputValidation();
 		String error = errorMessage.checkLoginInput(email, password);
		User result;
		try {
			if(error.isEmpty()) {
			LoginUser user = new LoginUser();
			result = user.getUser(email, password);
			if (result != null) {
				request.getSession().setAttribute("loggedInUser", user);
				rd = request.getRequestDispatcher("/userindex.jsp");
				
				request.setAttribute("user", result);
			} else {
				error += "Email/Password Invalid <br/>";
				request.setAttribute("error", error);
				rd = request.getRequestDispatcher("/login.jsp");
			}
			}
			else {
				request.setAttribute("error", error);
				rd = request.getRequestDispatcher("/login.jsp");
			}

			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
