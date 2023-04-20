package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.poly.constant.SessionAttribute;
import com.poly.entity.User;
import com.poly.service.EmailService;
import com.poly.service.UserService;
import com.poly.service.impl.EmailServiceImpl;
import com.poly.service.impl.UserServiceImpl;

@WebServlet({ "/Login", "/Register", "/Logout", "/ForgotPass", "/ChangePass", "/User"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private EmailService emailService = new EmailServiceImpl();
	User edtitUser;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/Login":
			doGetLogin(request, response);
			break;
		case "/Register":
			doGetRegister(request, response);
			break;
		case "/Logout":
			doGetLogout(session, request, response);
			break;
		case "/ForgotPass":
			doGetForgotPass(request, response);
			break;
		case "/User":
			doGetUser(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/Login":
			doPostLogin(session, request, response);
			break;
		case "/Register":
			doPostRegister(session, request, response);
			break;
		case "/ForgotPass":
			doPostForgotPass(request, response);
			break;
		case "/ChangePass":
			doPostChangePass(session, request, response);
			break;
		case "/User":
			doPostUser(request, response);
			break;
			
		}
	}

	private void doGetUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionParam = request.getParameter("action");    
		request.setAttribute("status", "Create");
		String Email = request.getParameter("Email");
		switch (actionParam) {
		case "Edit":
			doGetEdit(Email, request, response);
			break;
		case "Delete":
			doGetDelete(Email, request, response);
			break;
		}
	}
	
	private void doGetEdit(String Email, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		edtitUser = userService.findBy_Email(Email);
		request.setAttribute("form", edtitUser);
		request.setAttribute("status", "Update");
		request.setAttribute("users", userService.findAll("ID"));
		request.setAttribute("active", "CRUD_user");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}

	private void doGetDelete(String Email, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userService.delete(Email);
		request.setAttribute("status", "Create");
		request.setAttribute("users", userService.findAll("ID"));
		request.setAttribute("active", "CRUD_user");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);

	}
	
	private void doGetLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/User/LoginForm.jsp").forward(request, response);
	}

	private void doGetRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/User/RegisterForm.jsp").forward(request, response);
	}

	private void doGetLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.removeAttribute(SessionAttribute.CURRENT_USER);
		response.sendRedirect("index");
	}

	private void doPostUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	
		String status = request.getParameter("submitButton");
		if (status != null) {
			switch (status) {
			case "Update":
				doPostUpdate(request, response);
				break;
			}
		}
		request.setAttribute("status", "Create");
		request.setAttribute("users", userService.findAll("ID"));
		request.setAttribute("active", "CRUD_user");
		request.getRequestDispatcher("/views/User/index.jsp").forward(request, response);
	}
	
	private void doPostUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userService.update(GetUser(request));
	}

	private User GetUser(HttpServletRequest request) {
		edtitUser.setUserName(request.getParameter("UserName"));
		edtitUser.setEmail(request.getParameter("Email"));
		edtitUser.setAvatar(request.getParameter("Avatar"));
		return edtitUser;
	}
	
	private void doGetForgotPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/User/ForgotPass.jsp").forward(request, response);
	}

	private void doPostLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");

		User user = userService.Login(userName, password); // kt

		if (user != null) { 
			session.setAttribute(SessionAttribute.CURRENT_USER, user);
			response.sendRedirect("index");
		} else {
			request.setAttribute("status", "UserName hoặc Password không đúng. Vui lòng nhập lại");
			doGetLogin(request, response);
		}
	}

	private void doPostRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		String email = request.getParameter("Email");
		String image_Avtar = request.getParameter("Avatar");

		userService.create(image_Avtar, userName, password, email);

		User user = userService.Login(userName, password);

		if (user != null) {
//			emailService.sendMail(getServletContext(), user, "welcome");
			session.setAttribute(SessionAttribute.CURRENT_USER, user);
			response.sendRedirect("index");
		} else {
			request.setAttribute("status", "Đăng kí lại");
			doGetRegister(request, response);
		}
	}

	private void doPostForgotPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String email = request.getParameter("email");
		User userWithNewPassword = userService.resetPassword(email);
		if (userWithNewPassword != null) {
			response.setStatus(204);
			emailService.sendMail(getServletContext(), userWithNewPassword, "forgot");
		} else {
			response.setStatus(400);
		}
	}

	private void doPostChangePass(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String currentPassword = request.getParameter("CurrentPassword");
		String newPassword = request.getParameter("NewPassword");


		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);

		if (currentUser.getPassword().equals(currentPassword)) {
			currentUser.setPassword(newPassword);
			User updateUser = userService.update(currentUser);
			if (updateUser != null) {
				session.setAttribute(SessionAttribute.CURRENT_USER, updateUser);
				response.setStatus(204);
			} else {
				response.setStatus(400);
			}
		} else {
			response.setStatus(400);
		}

	}

}
