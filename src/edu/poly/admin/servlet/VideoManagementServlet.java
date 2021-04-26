package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUtils;
import edu.poly.dao.VideoDao;
import edu.poly.model.Video;

/**
 * Servlet implementation class VideoManagementServlet
 */
@WebServlet({ "/Admin/VideoManagement", "/Admin/VideoManagement/create", "/Admin/VideoManagement/update",
		"/Admin/VideoManagement/delete", "/Admin/VideoManagement/reset", "/Admin/VideoManagement/edit", })
@MultipartConfig

public class VideoManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}

		Video video = new Video();
		video.setPoster("images/sp1.jpg");
		request.setAttribute("video", video);
		findAll(request,response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}

		if (url.contains("update")) {
			update(request, response);
			return;
		}

		if (url.contains("reset")) {
			reset(request, response);
			return;
		}

	}
	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Video video = new Video();
		video.setPoster("images/logo.jpg");
		request.setAttribute("video",video);
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		if (id == null) {
			request.setAttribute("erro", "Video id is required");
			PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findbyId(id);
			if(video==null)
			{
				request.setAttribute("erro", "Video id not found");
				PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "Video was deleted !!");
			request.setAttribute("video",new Video());
			
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findbyId(video.getVideoId());
			if(request.getPart("cover").getSize()==0)
			{
				video.setPoster(oldVideo.getPoster());
			}
			else
			{
				video.setPoster("images/"+ UploadUtils.processUploadField("cover", request,"/images",video.getVideoId()));
			}
			dao.update(video);
			
			request.setAttribute("video", video);
			request.setAttribute("message", "Video is updated!!");
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			VideoDao dao = new VideoDao();
			 List<Video> list = dao.findAll();
			request.setAttribute("videos", list);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
	}
	
	

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		if (id == null) {
			request.setAttribute("erro", "Video id is required");
			PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findbyId(id);
			request.setAttribute("video", video);
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			video.setPoster("images/" + UploadUtils.processUploadField("cover", request, "/images", video.getVideoId()));
			VideoDao dao = new VideoDao();
			dao.insert(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Video installed");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro :" + e.getMessage());
		}
		findAll(request,response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

}
