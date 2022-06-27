package mvc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.RegisterUser;
import mvc.models.InputValidation;
import mvc.models.User;


/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		String email = request.getParameter("email");
		String phoneno = request.getParameter("phoneno");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("confirmpassword");
		RequestDispatcher rd = null;
		
		InputValidation errorMessage = new InputValidation();
 		String error = errorMessage.checkRegisterInput(username, email, phoneno, address, password, cpassword);
 		
		boolean result;
		try {
			if(error.isEmpty()) {
			RegisterUser registerUser = new RegisterUser();
			result = registerUser.createUser(username,email, phoneno, address, password);
				rd = request.getRequestDispatcher("/login.jsp");
				User user = new User(username,email, phoneno, address, password);
				request.setAttribute("user", user);
			} else {
				request.setAttribute("error", error);
				rd = request.getRequestDispatcher("/register.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
