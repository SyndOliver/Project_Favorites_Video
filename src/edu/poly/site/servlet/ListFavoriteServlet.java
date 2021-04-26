package edu.poly.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class ListFavoriteServlet
 */
@WebServlet(urlPatterns = { "/favorite", "/favorite/delete", "/favorite/share" })
public class ListFavoriteServlet extends HttpServlet {
	FavoriteDao fdao = new FavoriteDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!SessionUtils.isLogin(request))
		{
			response.sendRedirect("http://localhost:8080/Assginment_v2/Login");
			return;
		}
		String id = SessionUtils.getLoginedUsername(request);
		request.setAttribute("pages","favorite");
		if(id!=null)
		{ 	FavoriteDao dao = new FavoriteDao();
			List<Video> list = dao.findAllByUserId(id);
			if(list!=null)
			{
				request.setAttribute("items", list);
				PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FAVORITE_PAGE);
			}
			else 
			{
				request.setAttribute("erro","eroo");
			}
		}
		else 
		{
			request.setAttribute("erro","eroo");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("delete"))
		{
			this.Unlike(request, response);
		}
		else if(uri.contains("share")){
			String videoid = request.getParameter("videoId");
			response.sendRedirect("http://localhost:8080/Assginment_v2/ShareVideo?videoId = " + videoid);
		}
		doGet(request, response);
	}
	
	private void Unlike(HttpServletRequest request, HttpServletResponse response)
	{
		String id  = SessionUtils.getLoginedUsername(request);
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			FavoriteDao dao = new FavoriteDao();
			Favorite favorite = dao.findOneByUserIdAndVideoId(id, video.getVideoId());
			List<Video> list = dao.findAllByUserId(id);
			dao.delete(favorite.getFavoriteId());
			
			
		} catch (Exception e) {
			
		}
	}
	private void like(HttpServletRequest request, HttpServletResponse response)
	{
		String id  = SessionUtils.getLoginedUsername(request);
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			FavoriteDao dao = new FavoriteDao();
			Favorite favorite = dao.findOneByUserIdAndVideoId(id, video.getVideoId());
			List<Video> list = dao.findAllByUserId(id);
			dao.delete(favorite.getFavoriteId());
			
			
		} catch (Exception e) {
			
		}
	}
	
	
	

}
