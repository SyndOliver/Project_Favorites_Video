package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			System.out.println(emailAddress);
			UserDao dao = new  UserDao();
			User user= dao.findByUsernameIdAndEmail(username, emailAddress);
			if(username==null)
			{
				request.setAttribute("erro", "username or email are incorrect");
			}
			else {
				String form = emailAddress;
				Email email = new Email();
				email.setFrom("phuctmps13568@fpt.edu.vn");
				email.setFromPassword("01638102904phuc");
				email.setTo(emailAddress);
				System.out.println(emailAddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("You are used the forgot password function. <br>");
				sb.append("Your password is <b>").append(user.getPassword()).append("</b>");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				request.setAttribute("message","Email sent to Email ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("erro",e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

}
