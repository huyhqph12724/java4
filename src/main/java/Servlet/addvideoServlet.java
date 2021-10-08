package Servlet;

import java.io.IOException;
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
 * Servlet implementation class addvideoServlet
 */
@WebServlet("/admin/video/add")
public class addvideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addvideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/addvideo.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Videos video = new Videos();
		System.out.println("active"+ request.getParameter("active"));
		try {
			BeanUtils.populate(video, request.getParameterMap());
			if(request.getParameter("active").equals("1")) video.setActive(true);
			else video.setActive(false);
			VideoDAO dao = new VideoDAO();
			dao.insert(video);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		response.sendRedirect(request.getContextPath()+"/admin/video");
	}
	

}
