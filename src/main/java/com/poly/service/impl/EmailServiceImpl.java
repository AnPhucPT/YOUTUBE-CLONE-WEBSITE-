package com.poly.service.impl;

import javax.servlet.ServletContext;

import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.EmailService;
import com.poly.service.VideoService;
import com.poly.util.SendEmailUtil;

public class EmailServiceImpl implements EmailService {
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to youtube clone";
	private static final String EMAIL_FORGOT_PASSWORD = "Receive your password";
	
	VideoService videoService = new VideoServiceImpl();

	@Override
	public void sendMail(ServletContext context, User recipient, String type) {
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");

		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome": 
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Dear " + recipient.getUserName() + ", enjoy watching!"; 
				break;
			case "forgot" : 
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear " + recipient.getUserName() + ", your password: " + recipient.getPassword();
				break;
			default:
				subject = "Youtube clone";
				content = "Wrong email";
			}
			SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMail(ServletContext context, String ToEmail, String href,  String type) {
		
		String link = "https://www.youtube.com/watch?v=" + href;
		
		Video VideoUpdateShare = videoService.findBy_Href(href);
		VideoUpdateShare.setShares(VideoUpdateShare.getShares() + 1);
		videoService.update(VideoUpdateShare);
		
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");

		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "shareVideo": 
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Enjoy watching! " + link; 
				break;
			default:
				subject = "Youtube clone";
				content = "Wrong email";
			}
			SendEmailUtil.sendEmail(host, port, user, pass, ToEmail, subject, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
