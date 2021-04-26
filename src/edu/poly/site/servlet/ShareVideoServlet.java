package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.ShareDao;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.Share;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!SessionUtils.isLogin(request))
		{
			response.sendRedirect("Login");
			return;
		}
		
		String videoId = request.getParameter("videoId");
		if (videoId == null) {
			response.sendRedirect("/HomePage");
			return;
		}
		request.setAttribute("videoId", videoId);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String videoId = request.getParameter("videoId");
			String url = "http://localhost:8080/Assginment_v2/Detail?videoId=";
			if(videoId==null)
			{
				request.setAttribute("erro", "Video id is null!!");
			}
			else {
				Email email = new Email();
				email.setFrom("phuctmps13568@fpt.edu.vn");
				email.setFromPassword("01638102904phuc");
				email.setTo(emailAddress);
				email.setSubject("Share Favorite Video");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear Mr/Mrs ");
				sb.append("The video is more intersting and I want to share with you  <br>");
				sb.append("Please click the link<b>").append("<a href='").append(url).append(videoId).append("'>Click here <a/><br>");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				ShareDao dao = new ShareDao();
				Share share = new Share();
				share.setEmails(emailAddress);
				share.setShareDate(new Date());
				
				String username = SessionUtils.getLoginedUsername(request);
				User user= new User();
				user.setUsername(username);
				share.setUser(user);
				
				Video video = new Video();
				video.setVideoId(videoId);
				System.out.println(videoId);
				share.setVideo(video);
				
				dao.insert(share);
				request.setAttribute("message","Video link has been sent  ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("erro",e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
	}

}
