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
 * Servlet implementation class adduserServlet
 */
@WebServlet("/admin/user/add")
public class adduserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public adduserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/adduser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		System.out.println("role"+ request.getParameter("role"));
		try {
			BeanUtils.populate(user, request.getParameterMap());
			if(request.getParameter("role").equals("1")) user.setAdmin(true);
			else user.setAdmin(false);
			UserDAO dao = new UserDAO();
			dao.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		response.sendRedirect(request.getContextPath()+"/admin/user");
	}

}
