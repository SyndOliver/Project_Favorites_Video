package edu.poly.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.service.ReportService;

/**
 * Servlet implementation class IndexManagement
 */
@WebServlet("/IndexManagement")
public class IndexManagement extends HttpServlet {
  
	ReportService reportService = new  ReportService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("quantityUser", reportService.countUser());
		request.setAttribute("quantityVideo", reportService.countVideo());
		PageInfo.prepareAndForward(request, response, PageType.INDEX_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
