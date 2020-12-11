package com.javacodes.loginpage.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacodes.loginpage.database.LoginDAO;
import com.javacodes.loginpage.model.LoginModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String  username = request.getParameter("username");
		String  password = request.getParameter("password");
		
		LoginModel loginmodel = new LoginModel();
		
		loginmodel.setUsername(username);
		loginmodel.setPassword(password);
		
		LoginDAO logindao = new LoginDAO();
		
		if(logindao.validate(loginmodel)) {
			response.sendRedirect("LoginSuccess.jsp");
			
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}

}
