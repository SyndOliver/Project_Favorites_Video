package edu.poly.service;

import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;

public class ReportService {
	UserDao udao = new UserDao();
	VideoDao vDao = new VideoDao();
	public int countUser()
	{
		return udao.findAll().size();
	}
	public int countVideo()
	{
		return vDao.findAll().size();
	}
}
