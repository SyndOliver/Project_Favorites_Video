package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.ShareDao;
import edu.poly.dao.VideoDao;
import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteShareReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.domain.ShareUserReport;
import edu.poly.model.Video;


@WebServlet("/ReportsManagementServlet")
public class ReportsManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		share(request, response);
		reportFavoriteByVideos(request, response);
		reportFavoriteUserByVideos(request, response);
		PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMRNT_PAGE); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void share(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoShareId = request.getParameter("videoShareId");
			request.setAttribute("videoShareId", videoShareId);
			System.out.println(videoShareId);
			VideoDao dao = new VideoDao();
			List<Video> vlist = dao.findAll();
			request.setAttribute("videoList", vlist);
			System.out.println(vlist);
			ShareDao sdao = new ShareDao();
			List<ShareUserReport> list =sdao.reportShareUserByVideos(videoShareId);
			request.setAttribute("shareUser", list);
			System.out.println(list);
			
			//System.out.println(vlist);
		} catch (Exception e) {
			request.setAttribute("message"," "+e.getMessage());
		}
	}
	
	protected void reportFavoriteUserByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoUserId = request.getParameter("videoUserId");
			VideoDao vdao = new VideoDao();
			List<Video> vlist = vdao.findAll();
			
			if(videoUserId==null &&vlist.size()>0)
			{
				videoUserId = vlist.get(0).getVideoId();
			}
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteUserReport> list = dao.reportFavoriteUserByVideos(videoUserId);
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("vidlist", vlist);
			
			request.setAttribute("favuser",list);
			
		} catch (Exception e) {
			request.setAttribute("message"," "+e.getMessage());
		}	
	}
	
	
	protected void reportFavoriteByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavoriteByVideos();
			request.setAttribute("favlist",list);
			
		} catch (Exception e) {
			request.setAttribute("message"," "+e.getMessage());
		}	
	}

}
