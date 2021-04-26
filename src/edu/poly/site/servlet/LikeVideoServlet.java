package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class LikeVideoServlet
 */
@WebServlet("/LikeVideo")
public class LikeVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		if(!SessionUtils.isLogin(request))
		{
			response.sendRedirect("Login");
			return;
		}
		String page = request.getParameter("page");
		String videoId = request.getParameter("videoId");
		System.out.println(videoId);
		
		if (videoId == null) {
			response.sendRedirect("/Assginment_v2/HomePage");
			return;
		}
		try {
			FavoriteDao dao = new FavoriteDao();
			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setVideoId(videoId);
			favorite.setVideo(video);
			
			String username = SessionUtils.getLoginedUsername(request);
			User user  = new User();
			user.setUsername(username);
			favorite.setUser(user);
			
			favorite.setLikeDate(new Date());
			dao.insert(favorite);
			request.setAttribute("count", count++);
			request.setAttribute("message", "Video is add to Favorite");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
			
		}
		if(page==null)
		{
			page="/HomePage";
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
