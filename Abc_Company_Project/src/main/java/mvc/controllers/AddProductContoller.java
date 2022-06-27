package mvc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.AddProduct;
import dbconnect.RegisterUser;
import mvc.models.InputValidation;
import mvc.models.User;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProductController")
public class AddProductContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductContoller() {
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
		String name = request.getParameter("productname");
		String model = request.getParameter("productmodel");
	
		
		
		RequestDispatcher rd = null;
		
		InputValidation errorMessage = new InputValidation();
 		String error = errorMessage.checkProductInput(name, model);
 		
		boolean result;
		try {
			if(error.isEmpty()) {
			AddProduct add = new AddProduct();
			result = add.createProduct(name, model);
				rd = request.getRequestDispatcher("AllUserandProduct?id=allproducts");
			} else {
				request.setAttribute("error", error);
				rd = request.getRequestDispatcher("/addproduct.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
