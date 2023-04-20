package com.poly.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.Dto.UserDto;
import com.poly.Dto.VideoLiked;
import com.poly.constant.SessionAttribute;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.StatisticalService;
import com.poly.service.UserService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.StatisticalServiceImpl;
import com.poly.service.impl.UserServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class HomeControllerAdmin
 */
@WebServlet({ "/Admin", "/Admin/Favorites", "/Favorites", "/History", "/CRUD_video", "/CRUD_user" })
public class HomeController_Admin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StatisticalService s_service = new StatisticalServiceImpl();
	private UserService userService = new UserServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();
	private VideoService videoService = new VideoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		if (currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
			String path = request.getServletPath();
			switch (path) {
			case "/Admin":
				doGetHome(request, response);
				break;
			case "/Admin/Favorites":
				doGetFavorites(request, response);
				break;
			case "/Favorites":
				doGetFavorites(session, request, response);
				break;
			case "/History":
				doGetHistory(session, request, response);
				break;
			case "/CRUD_video":
				doGetCRUD_Video(session, request, response);
				break;
			case "/CRUD_user":
				doGetCRUD_user(session, request, response);
				break;
			
			}
		
		} else {
			response.sendRedirect("index");
		}
	}

	private void doGetHistory(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		List<History> histories = historyService.findBy_UserName(user.getUserName());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		request.setAttribute("videos", videos);
		request.setAttribute("active", "Histories");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}

	private void doGetFavorites(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttribute.CURRENT_USER);

		List<History> histories = historyService.findBy_UserName_And_IsLiked(user.getUserName());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		request.setAttribute("videos", videos);
		request.setAttribute("active", "Favorites");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}

	private void doGetCRUD_Video(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("videos", videoService.findAll("ID"));
		request.setAttribute("active", "CRUD_video");
		request.setAttribute("status", "Create");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}
	
	private void doGetCRUD_user(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("users", userService.findAll("ID"));
		request.setAttribute("active", "CRUD_user");
		request.setAttribute("status", "Create");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}

	private void doGetHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<VideoLiked> videos = s_service.find_VideoLike();
		request.setAttribute("videos", videos);
		request.setAttribute("active", "admin_favorites");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}

	private void doGetFavorites(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		
		String videoHref = request.getParameter("Href");
		List<UserDto> users = userService.finUserLikedByVideoHref(videoHref);
		if (users.isEmpty()) {
			response.setStatus(400);
		} else {
			ObjectMapper mapper = new ObjectMapper();
			String dataResponse = mapper.writeValueAsString(users);
			response.setStatus(200);
			out.print(dataResponse);
			out.flush();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
