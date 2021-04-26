package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUtils;
import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.User;
import edu.poly.model.Video;



/**
 * Servlet implementation class UserMangementServlet
 */
@WebServlet({ "/Admin/UserManagement", "/Admin/UserManagement/create", "/Admin/UserManagement/update",
	"/Admin/UserManagement/delete", "/Admin/UserManagement/reset", "/Admin/UserManagement/edit", })
public class UserMangementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		findAll(request, response);
		
		PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();
			User oldUser = dao.findbyId(user.getUsername());
			dao.update(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Video is updated!!");
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
		
		PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
		
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setAdmin(false);
			UserDao dao = new UserDao();
			dao.insert(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "User installed");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro :" + e.getMessage());
		}
		findAll(request,response);
		/*request.setAttribute("view", "/admin/users/user.jsp");
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);;*/
		PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
		
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setAttribute("user",user);
		findAll(request, response);
		
		/*request.setAttribute("view", "/admin/users/user.jsp");
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);;*/
		PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");
		if (id == null) {
			request.setAttribute("erro", "Username is required");
			
			/*request.setAttribute("view", "/admin/users/user.jsp");
			request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);;*/
			PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findbyId(id);
			if(user==null)
			{
				request.setAttribute("erro", "User id not found");
				
				/*request.setAttribute("view", "/admin/users/user.jsp");
				request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);;*/
				PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "User was deleted !!");
			request.setAttribute("user",new User());
			
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
		/*request.setAttribute("view", "/admin/users/user.jsp");
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);;*/
		PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");
		if (id == null) {
			request.setAttribute("erro", "Username is required");
			PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
			/*request.setAttribute("view", "/admin/users/user.jsp");
			request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);*/
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findbyId(id);
			request.setAttribute("user", user);
			findAll(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
		/*request.setAttribute("view", "/admin/users/user.jsp");
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);;*/
		PageInfo.prepareAndForward(request, response,PageType.USER_MANAGEMENT_PAGE);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			 UserDao dao = new UserDao();
			 List<User> list = dao.findAll();
			 request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro : " + e.getMessage());
		}
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("view", "/admin/users/user.jsp");
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
	}
}
