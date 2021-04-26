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
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {
			
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println(user.getFullname());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getAdmin());
			UserDao dao = new UserDao();
			dao.insert(user);
			request.getRequestDispatcher("/Login").forward(request, response);
			System.out.println(user);
			return;

		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
		}
		request.setAttribute("user", user);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

}
