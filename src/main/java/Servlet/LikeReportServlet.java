package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDAO;
import DAO.UserDAO;
import Model.Like;
import Model.User;

/**
 * Servlet implementation class LikeReportServlet
 */
@WebServlet("/admin/like")
public class LikeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LikeReportServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoriteDAO fdao = new FavoriteDAO();
		UserDAO dao = new UserDAO();
		String username = (String) SessionUtil.get(request, "username");
		Boolean role =  (Boolean) SessionUtil.get(request,"role");
		System.out.println("Role: "+ role);
		if(username != null) {
			role = dao.findById(username).getAdmin();
		}
		if(username == null || role == false){
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			return;
		}
		try {	
			List<Like> list = fdao.likeReport();
			request.setAttribute("like", list);	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		request.getRequestDispatcher("/admin/like.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
