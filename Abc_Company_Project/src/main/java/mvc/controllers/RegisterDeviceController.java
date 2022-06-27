package mvc.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.GetData;
import dbconnect.RegisterDevice;
import dbconnect.RegisterUser;
import mvc.models.RegisteredDevice;
import mvc.models.User;

/**
 * Servlet implementation class RegisterDeviceController
 */
@WebServlet("/RegisterDeviceController")
public class RegisterDeviceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDeviceController() {
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
		String prodname = request.getParameter("productname");
		String serialno = request.getParameter("serialno");
		//String date = request.getParameter("date");
		
		RequestDispatcher rd = null;
		boolean result;
		try {
			GetData data = new GetData();
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			RegisterDevice registerDevice = new RegisterDevice();
			result = registerDevice.regDevice(username,prodname, serialno,sqlDate );
			ArrayList<RegisteredDevice> devices = data.getAllRegisteredDevice();
			if (result) {
				rd = request.getRequestDispatcher("/selectdevice.jsp");
				request.setAttribute("devicelist", devices);
				RegisteredDevice device = new RegisteredDevice(username,prodname, serialno,sqlDate);
				request.setAttribute("device", device);
				request.setAttribute("user", username);
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
