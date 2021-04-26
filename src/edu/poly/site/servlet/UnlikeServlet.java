package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class UnlikeServlet
 */
@WebServlet("/Unlike")
public class UnlikeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		String page = request.getParameter("page");
		String videoId = request.getParameter("videoId");
		if(videoId == null) {
			response.sendRedirect("HomePage");
			return;
		}
		
		String username = SessionUtils.getLoginedUsername(request);
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			FavoriteDao dao = new FavoriteDao();
			Favorite favorite = dao.findOneByUserIdAndVideoId(username, video.getVideoId());
			dao.delete(favorite.getFavoriteId());
			request.setAttribute("message", "Video is delete to Favorite ");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		if(page == null) {
			page = "/HomePage";
		}
		request.getRequestDispatcher(page).forward(request, response);
				
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
