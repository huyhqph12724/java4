package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DAO.VideoDAO;

/**
 * Servlet implementation class deletevideoServlet
 */
@WebServlet("/admin/video/delete")
public class deletevideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletevideoServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("/video/delete")) {
			String videoid = request.getParameter("uid");
			VideoDAO dao = new VideoDAO();
			try {
				dao.delete(videoid);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			response.sendRedirect(request.getContextPath()+"/admin/video");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
