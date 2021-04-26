package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findbyId(username);
			request.setAttribute("user", user);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("erro", "" + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_EDIT_PROFILE_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			
			BeanUtils.populate(user, request.getParameterMap());
		
			String username = SessionUtils.getLoginedUsername(request);
			System.out.println(username);
			UserDao dao = new UserDao();
			User olduser = dao.findbyId(username);
			user.setAdmin(olduser.getAdmin());
			user.setPassword(olduser.getPassword());
			System.out.println(user.getUsername());
			System.out.println(user.getFullname());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getAdmin());
			
			dao.update(user);
			request.setAttribute("message", "User Updated!!!");
			request.setAttribute("user", user);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "" + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_EDIT_PROFILE_PAGE);
	}

}
