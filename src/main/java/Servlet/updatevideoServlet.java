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
 * Servlet implementation class updatevideoServlet
 */
@WebServlet("/admin/video/update")
public class updatevideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoDAO dao = new VideoDAO();
	Videos video = new Videos();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatevideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("/video/update")) {
			String videoid = request.getParameter("uid");
			Videos video = dao.findById(videoid);
			request.setAttribute("video", video);
		}
		request.getRequestDispatcher("/admin/updatevideo.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BeanUtils.populate(video, request.getParameterMap());
			if(request.getParameter("active").equals("1")) video.setActive(true);
			else video.setActive(false);
			System.out.println("video id"+video.getVideoId());
			System.out.println("INFO"+video.getTitle());
			dao.update(video);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		response.sendRedirect(request.getContextPath()+"/admin/video");
	
	}

}
