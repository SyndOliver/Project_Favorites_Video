package edu.poly.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	static {
		pageRoute.put(PageType.INDEX_PAGE, new PageInfo("Index", "/admin/index.jsp", null));
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Mangement", "/admin/users/user.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGEMRNT_PAGE, new PageInfo("Reports", "/admin/report/reports.jsp", null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management", "/admin/video/videos.jsp", null));
		
		
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home Page", "/side/home/home.jsp", null));	
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login Page", "/side/users/login.jsp", null));
		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration", "/side/users/registration.jsp", null));
		
		pageRoute.put(PageType.SITE_CHANGEPASSWORD_PAGE, new PageInfo("Change Password", "/side/users/changepassword.jsp", null));
		pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile", "/side/users/edit-profile.jsp", null));
		pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password", "/side/users/forgot-password.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorite", "/side/report/favorite.jsp", null));
		pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Video Detail", "/side/video/detail.jsp", null));
		pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Share", "/side/video/share.jsp", null));
		pageRoute.put(PageType.SITE_DETAIL_PAGE, new PageInfo("Detail", "/side/home/detail.jsp", null));
		pageRoute.put(PageType.SITE_DETAIL_PAGE, new PageInfo("Detail", "/side/home/detail.jsp", null));
		
		pageRoute.put(PageType.SITE_ABOUT_US_PAGE, new PageInfo("AboutUs", "/side/home/aboutus.jsp", null));
		pageRoute.put(PageType.SITE_CONTACT_US_PAGE, new PageInfo("ContactUs", "/side/home/contactus.jsp", null));
		
		
		
	}

	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response, PageType pageType)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);

		request.setAttribute("page", page);

		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}
	
	public static void prepareAndForwardSite(HttpServletRequest request, HttpServletResponse response, PageType pageType)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);

		request.setAttribute("page", page);

		request.getRequestDispatcher("/side/layout.jsp").forward(request, response);
	}

	private String title;
	private String contentUrl;
	private String scriptUrl;

	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getScriptUrl() {
		return scriptUrl;
	}

	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}

}
