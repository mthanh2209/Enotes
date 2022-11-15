package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PostDAO;
import com.Db.DBCon;
import com.User.Post;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {
	// những dữ liệu thay đổi thì sử dụng phương thức POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// chuyen doi dau vao cua ng dung o dinh dang chuoi thanh 1 loai doi tuong manh
		// hon
		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");// de nhan gia tri cua tham so form
		String content = request.getParameter("content");

		PostDAO dao = new PostDAO(DBCon.getConn());
		boolean f = dao.AddNotes(title, content, uid);

		if (f) {
			System.out.println("data insert successfully");
			response.sendRedirect("showNotes.jsp");// chuyen huong trang den shownote
		} else {
			System.out.println("data not inserted");
		}
	}

}
