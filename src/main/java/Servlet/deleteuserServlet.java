package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;

/**
 * Servlet implementation class deleteuserServlet
 */
@WebServlet("/admin/user/delete")
public class deleteuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleteuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("/user/delete")) {
			String username = request.getParameter("uid");
			UserDAO dao = new UserDAO();
			try {
				dao.delete(username);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			response.sendRedirect(request.getContextPath()+"/admin/user");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
