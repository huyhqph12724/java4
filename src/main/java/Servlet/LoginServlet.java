package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import Model.LoginForm;
import Model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtil.get("username", request);
		if(username == null){
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			return;
		}
		SessionUtil.add(request, "username", username);
		request.getRequestDispatcher("/website.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDAO dao = new UserDAO();
			User user = dao.findById(form.getUsername());
			if(user!= null && user.getPassword().equals(form.getPassword())){
				SessionUtil.add(request, "username", user.getUsername());
				SessionUtil.add(request, "role", user.getAdmin());
				System.out.println(SessionUtil.get(request, "role"));
				if(form.isRemember()) {
					CookieUtil.add("username", form.getUsername(), 24, response);
				}else {
					CookieUtil.add("username", form.getUsername(), 0, response);
				}
				request.setAttribute("isLogin", true);
				response.sendRedirect(request.getContextPath()+"/Homepage");
				return;
			}else {
				if(user!= null && !user.getPassword().equals(form.getPassword())) {
					request.setAttribute("err", "Mật khẩu sai");
				}
				if(user == null) {
					request.setAttribute("err", "Tên đăng nhập sai");
				}
				request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/user/login");
	}

}
