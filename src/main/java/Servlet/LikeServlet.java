package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDAO;
import Model.Favorite;
import Model.User;
import Model.Videos;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return;
		}
		String videoId = request.getParameter("videoId");
		System.out.println(videoId);
		if(videoId == null) {
			response.sendRedirect(request.getContextPath()+"/Homepage");
			return;
		}
		try {
			FavoriteDAO dao = new FavoriteDAO();
			Favorite favorite = new Favorite();
			Videos video = new Videos();
			video.setVideoId(videoId);
			favorite.setVideo(video);
			String username = SessionUtil.getLoginUsername(request);
			System.out.println("username:"+ username);
			User user = new User();
			user.setUsername(username);
			favorite.setUser(user);
			favorite.setLikeDate(new Date());
			dao.insert(favorite);
			request.setAttribute("like", "Đã thích video");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Homepage").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
