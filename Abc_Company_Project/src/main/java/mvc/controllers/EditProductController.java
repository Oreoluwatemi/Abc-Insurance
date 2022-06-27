package mvc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.AddProduct;
import mvc.models.InputValidation;

/**
 * Servlet implementation class EditProductController
 */
@WebServlet("/EditProductController")
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductController() {
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
		String id = request.getParameter("productid");
		String model = request.getParameter("productmodel");
		
		
		
		RequestDispatcher rd = null;
		
		InputValidation errorMessage = new InputValidation();
 		String error = errorMessage.checkProductInput(id, model);
 		
		boolean result;
		try {
			if(error.isEmpty()) {
				int prodid = Integer.parseInt(id);
			AddProduct add = new AddProduct();
			result = add.editProduct(prodid, model);
				rd = request.getRequestDispatcher("AllUserandProduct?id=allproducts");
			} else {
				request.setAttribute("error", error);
				rd = request.getRequestDispatcher("/editproduct.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
