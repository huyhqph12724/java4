package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DAO.VideoDAO;
import Model.User;
import Model.Videos;

/**
 * Servlet implementation class adminvideoServlet
 */
@WebServlet("/admin/video")
public class adminvideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public adminvideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO udao = new UserDAO();
		VideoDAO dao = new VideoDAO();
		String username = (String) SessionUtil.get(request, "username");
		Boolean role =  (Boolean) SessionUtil.get(request,"role");
		System.out.println("Role: "+ role);
		if(username != null) {
			role = udao.findById(username).getAdmin();
		}
		if(username == null || role == false){
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			return;
		}
		try {	
			List<Videos> listvideo = dao.fillAll();
			request.setAttribute("videos", listvideo);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher("/admin/videos.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
