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
import edu.poly.domain.ChangePasswordForm;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			System.out.println(username);
			return;
		}
		System.out.println(username);
		request.setAttribute("username", username);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(request);
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, request.getParameterMap());
			
			System.out.println(form.getCurrentPassword());
			System.out.println(form.getConfirmPassword());
			System.out.println(form.getPassword());
			request.setAttribute("username", username);
			if(!(form.getConfirmPassword().equals(form.getCurrentPassword())))
			{
				request.setAttribute("erro", "new password and new confirm password are not indentical");
			}
			else {
				UserDao dao = new UserDao();
				dao.changePassword(form.getUsername(), form.getPassword(), form.getCurrentPassword());
				request.setAttribute("message","Password has been changed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}

}
