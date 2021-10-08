package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import Model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/user/register.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		UserDAO dao = new UserDAO();
		User user = new User();
		List<User> lst = dao.fillAll();
		for(User u: lst) {
			if(request.getParameter("username").equalsIgnoreCase(u.getUsername()))
				sb.append("Tên đăng nhập đã tồn tại \n");
			if(request.getParameter("email").equals(u.getEmail()))
				sb.append("email đã tồn tại");
		}
		if(sb.length()>0) {
			request.setAttribute("mss", sb);
			request.getRequestDispatcher("/user/register.jsp").forward(request, response);
			return;
		}
		user.setAdmin(false);
		user.setEmail(request.getParameter("email"));
		user.setFullname(request.getParameter("fullname"));
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));
		try {
			//BeanUtils.populate(user, request.getParameterMap());
			dao.insert(user);
			request.setAttribute("mss", "Đăng ký thành công");
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
