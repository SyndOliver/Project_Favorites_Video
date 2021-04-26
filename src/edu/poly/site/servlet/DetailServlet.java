package edu.poly.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.filter.CookieUtils;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet(urlPatterns = {"/Detail","/Detail/delete"}) 

public class DetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		String videoId = request.getParameter("videoId");
		System.out.println(videoId);
		FavoriteDao fdao = new FavoriteDao();
		Video video = new Video();
		VideoDao dao = new VideoDao();
		video =dao.findbyId(videoId);
		request.setAttribute("videodetail", video); 

		try {
			if(username!=null)
			{
				Favorite favorite = fdao.findOneByUserIdAndVideoId(username, videoId);
				request.setAttribute("favorite", favorite);
				
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_DETAIL_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	

	
}
