package edu.poly.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.Video;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePage")
public class HomePageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = SessionUtils.getLoginedUsername(request);
			VideoDao dao = new  VideoDao(); 
			List<Video> list = dao.findAll();
			request.setAttribute("videos", list);
			if(id==null)
			{
				request.setAttribute("videos", list);
				PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
				return ;
			}
			FavoriteDao fdao = new FavoriteDao();
			List<Video> listfav = fdao.findAllByUserId(id);
			request.setAttribute("listF", listfav);
			request.setAttribute("videos", list);
			request.setAttribute("id", id);
		} catch (Exception e) {
			
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
