package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDAO;
import DAO.VideoDAO;
import Model.*;
/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Homepage")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //${pageContext.request.contextPath}
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDAO dao = new VideoDAO();
			List<Videos> listvideo = dao.fillAll();
			FavoriteDAO fdao = new FavoriteDAO();
			List<Like> list = fdao.likeReport();
			request.setAttribute("like", list);
			request.setAttribute("videos", listvideo);
			request.getRequestDispatcher("/website.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
