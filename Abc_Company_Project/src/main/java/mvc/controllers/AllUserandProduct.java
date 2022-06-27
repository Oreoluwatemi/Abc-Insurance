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
import mvc.models.Product;
import mvc.models.RegisteredDevice;
import mvc.models.User;

/**
 * Servlet implementation class AllUsersContoller
 */
@WebServlet("/AllUserandProduct")
public class AllUserandProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUserandProduct() {
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
			ArrayList<RegisteredDevice> devices = data.getAllRegisteredDevice();
			RequestDispatcher rd = null;
			
			String id = request.getParameter("id");
			if(id.equals("allusers")) {
				log("true");
				request.setAttribute("userlist", users);
			rd = request.getRequestDispatcher("/allusers.jsp");
			
			}
			else if(id.equals("allproducts")) {
				request.setAttribute("productlist", products);
				rd = request.getRequestDispatcher("/allproducts.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
