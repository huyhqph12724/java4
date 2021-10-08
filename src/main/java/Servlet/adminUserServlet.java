package Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import DAO.VideoDAO;
import Model.User;
import Model.Videos;

/**
 * Servlet implementation class adminUser
 */
@WebServlet({"/admin/user"})
public class adminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public adminUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
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
			List<User> listuser = dao.fillAll();
			request.setAttribute("users", listuser);	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
