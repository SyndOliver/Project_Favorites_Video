package edu.poly.site.servlet;

import java.io.IOException;
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
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import edu.poly.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		String password = CookieUtils.get("password", request);
		
		if(username==null)
		{
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
			return ;
		}
		SessionUtils.add(request,"username", username);
		request.getRequestDispatcher("/HomePage").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkRemember = request.getParameter("txtRemember");
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDao dao = new UserDao();
			User user = dao.findbyId(form.getUsername());
			if(user!=null && user.getPassword().equals(form.getPassword()))
			{
				SessionUtils.add(request,"username", user.getUsername());
				if(checkRemember!=null)
				{
					CookieUtils.add("username", form.getUsername(), 24, response);
					CookieUtils.add("password", form.getPassword(), 1, response);
				}else {
					CookieUtils.add("username", form.getUsername(), 0, response);
					CookieUtils.add("password", form.getPassword(), 0, response);
				}
				
				if(this.isAdmin(user))
				{
					response.sendRedirect("http://localhost:8080/Assginment_v2/Admin/UserManagement");
				}
				else {
					response.sendRedirect("http://localhost:8080/Assginment_v2/HomePage");
				}
				
				
				request.setAttribute("isLogin", true);
				request.setAttribute("name", user.getFullname());
				//request.getRequestDispatcher("HomePage").forward(request, response);
				return;
			}
			request.setAttribute("erro","invalid username or password");
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
		} catch (Exception e) {
			request.setAttribute("erro", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
	}
	
	private boolean isAdmin(User user) {
		if(user.getAdmin())
		{
			return true;
		}
		return false;
	}
	
	
	
	private void createSession(HttpServletRequest request, User userModal) {
		HttpSession session = request.getSession();
		session.setAttribute("userSession", userModal);
	}

}
