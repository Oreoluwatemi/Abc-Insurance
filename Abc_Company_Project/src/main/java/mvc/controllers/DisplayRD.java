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
import dbconnect.LoginUser;
import mvc.models.Product;
import mvc.models.User;

/**
 * Servlet implementation class DisplayRD
 */
@WebServlet("/DisplayRD")
public class DisplayRD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayRD() {
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
			ArrayList<Product> products = data.getAllProducts();
			ArrayList<User> users = data.getAllUsers();
			RequestDispatcher rd = null;
			
			String currentUserEmail = request.getParameter("id");
			log(currentUserEmail);
			String currentUserName = null; 
			
			for(int i = 0; i < users.size(); i++) {
				log(users.get(i).getEmail());
				if(currentUserEmail.equals(users.get(i).getEmail())) {
					currentUserName = users.get(i).getUsername();
					this.user = users.get(i);
					
				}
			}
			rd = request.getRequestDispatcher("/registerdevice.jsp");
				
			request.setAttribute("productlist", products);
			request.setAttribute("userlist", users);
			request.setAttribute("user", this.user);
			
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
