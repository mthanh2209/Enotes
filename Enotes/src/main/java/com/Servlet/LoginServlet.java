package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBCon;
import com.User.UserDetails;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	// những dữ liệu thay đổi thì sử dụng phương thức POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// trích xuất các tham số yêu cầu
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");

		UserDetails us = new UserDetails();
		us.setEmail(email);
		us.setPassword(password);

		UserDAO dao = new UserDAO(DBCon.getConn());
		UserDetails user = dao.loginUser(us);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userD", user);
			response.sendRedirect("home.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("login-failed", "Invalid UserName and Password");
			response.sendRedirect("login.jsp");
		}
	}

}
