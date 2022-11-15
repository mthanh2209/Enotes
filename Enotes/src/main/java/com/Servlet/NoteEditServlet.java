package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;
import com.Db.DBCon;

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	//những dữ liệu thay đổi thì sử dụng phương thức POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			//de nhan gia tri tu ng dung
			String Title = request.getParameter("title");
			String Content = request.getParameter("content");
			
			PostDAO dao = new PostDAO(DBCon.getConn());
			boolean f=dao.PostUpdate(noteid, Title, Content);
			
			if(f) {
				System.out.println("data update successfully");
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Notes Update Successfully");
				response.sendRedirect("showNotes.jsp");//chuyen huong trang
			}else {
				System.out.println("data not update");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
