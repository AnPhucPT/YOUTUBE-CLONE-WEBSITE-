package com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttribute;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet({ "/index"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final int MAX_VIDEO_IN_EACH_PAGE = 6;
	
	private VideoService videoService = new VideoServiceImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		
		switch (path) {
		case "/index":               
			doGetIndex(request, response);
			break;
		}
	}

	private void doGetIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//--------------------------------------------------------
		int maxPage = (int) Math.ceil(videoService.findAll().size() / (double) MAX_VIDEO_IN_EACH_PAGE);
		request.setAttribute("maxPage", maxPage);
//--------------------------------------------------------
		List<Video> videos;
		String pageNumber = request.getParameter("page");
//--------------------------------------------------------
		if (pageNumber == null || Integer.valueOf(pageNumber) > maxPage) {
			videos = videoService.findAll(1, MAX_VIDEO_IN_EACH_PAGE, "ID");
			request.setAttribute("currentPage", 1);
		} else {
			videos = videoService.findAll(Integer.valueOf(pageNumber), MAX_VIDEO_IN_EACH_PAGE, "ID");
			request.setAttribute("currentPage", Integer.valueOf(pageNumber));
		}
//--------------------------------------------------------
		request.setAttribute("videos", videos);
		request.setAttribute("active", "Home");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
