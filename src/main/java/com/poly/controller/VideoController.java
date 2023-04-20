package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.poly.Dto.VideoLiked;
import com.poly.constant.SessionAttribute;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.EmailService;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.EmailServiceImpl;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class VideoController
 */
@WebServlet({ "/Video", "/Share" })
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoService videoService = new VideoServiceImpl();
	private static HistoryService historyService = new HistoryServiceImpl();
	private EmailService emailService = new EmailServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionParam = request.getParameter("action");
		request.setAttribute("status", "Create");
		String href = request.getParameter("ID");
		HttpSession session = request.getSession();

		switch (actionParam) {
		case "watch":
			doGetWatch(session, href, request, response);
			break;
		case "like":
			doGetLike(session, href, request, response);
			break;

		case "Edit":
			doGetEdit(href, request, response);
			break;
		case "Delete":
			doGetDelete(href, request, response);
			break;
		}
	}

	private void doGetWatch(HttpSession session, String href, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Video video = videoService.findBy_Href(href);
		request.setAttribute("video", video);
		request.setAttribute("videos", videoService.findRandomVideo(href, 6));

		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		if (currentUser != null) {
			History history = historyService.create(currentUser, video);
			request.setAttribute("flagLikeBtn", history.getIsLike());
		}

		request.getRequestDispatcher("/views/User/Video_Detail.jsp").forward(request, response);
	}

	private void doGetLike(HttpSession session, String href, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		boolean result = historyService.update_LikeOrUnlike(currentUser, href);
		if (result) {
			response.setStatus(204);
		} else {
			response.setStatus(400);
		}

	}

	private void doGetEdit(String href, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		Video edtitVideo = videoService.findBy_Href(href);
		request.setAttribute("form", edtitVideo);
		request.setAttribute("status", "Update");
		request.setAttribute("videos", videoService.findAll("ID"));
		request.setAttribute("active", "CRUD_video");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}

	private void doGetDelete(String href, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		videoService.delete(href);
		request.setAttribute("status", "Create");
		request.setAttribute("videos", videoService.findAll("ID"));
		request.setAttribute("active", "CRUD_video");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		if (path == "/Share") {
			System.out.println(path);
			String href = request.getParameter("ID");
			switch (path) {
			case "/Share":
				doPostShare(href, request, response);
				break;
			}
		} else {
			System.out.println("hello wolr");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");

			String status = request.getParameter("submitButton");	
			if (status != null) {
				switch (status) {
				case "Create":
					doPostCreate(request, response);
					break;
				case "Update":
					doPostUpdate(request, response);
					break;
				}
			}
			request.setAttribute("status", "Create");
			request.setAttribute("videos", videoService.findAll("ID"));
			request.setAttribute("active", "CRUD_video");
			request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
		}

	}

	private void doPostShare(String href, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String email = request.getParameter("Email");
		
		response.setStatus(204);
		emailService.sendMail(getServletContext(), email, href, "shareVideo");

	}

	private void doPostCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		videoService.create(GetVideo(request));
	}

	private void doPostUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		videoService.update(GetVideo(request));
	}

	private Video GetVideo(HttpServletRequest request) {
		Video video = new Video();
		video.setHref(request.getParameter("Href"));
		video.setTitle(request.getParameter("Title"));
		video.setDescription(request.getParameter("description"));
		video.setIsActive(Boolean.TRUE);
		video.setViews(0);
		video.setShares(0);
		return video;
	}

}
