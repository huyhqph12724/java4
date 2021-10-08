package Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import Model.User;

/**
 * Servlet implementation class updateuserServlet
 */
@WebServlet("/admin/user/update")
public class updateuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	User user = new User();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("/user/update")) {
			String username = request.getParameter("uid");
			User user = dao.findById(username);
			request.setAttribute("user", user);
		}
		request.getRequestDispatcher("/admin/updateuser.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
			if(request.getParameter("role").equals("1")) user.setAdmin(true);
			else user.setAdmin(false);
			System.out.println("username"+user.getUsername());
			System.out.println("INFO"+user.getUsername()+user.getFullname());
			dao.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		response.sendRedirect(request.getContextPath()+"/admin/user");
	}

}
