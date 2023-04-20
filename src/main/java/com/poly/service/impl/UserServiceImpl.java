package com.poly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.Dto.UserDto;
import com.poly.constant.NameParameter;
import com.poly.dao.UserDAO;
import com.poly.dao.impl.UserDAOImpl;
import com.poly.entity.User;
import com.poly.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	
	public UserServiceImpl () {
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public User findBy_ID(Integer ID) {
		return userDAO.findBy_ID(ID);
	}

	@Override
	public User findBy_Email(String Email) {
		return userDAO.findBy_Email(Email);
	}

	@Override
	public User findBy_UserName(String UserName) {
		return userDAO.findBy_UserName(UserName);
	}

	@Override
	public User Login(String UserName, String Password) {
		return userDAO.findBy_UserName_And_Password(UserName, Password);
	}

	@Override
	public User resetPassword(String email) {
		User existUser = findBy_Email(email);
		if ( existUser != null) {
			String newPass = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));
			existUser.setPassword(newPass);
			return userDAO.update(existUser);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public List<User> findAll(int PageNumber, int PageSize) {
		return userDAO.findAll(PageNumber, PageSize);
	}
	
	@Override
	public List<User> findAll(String column) {
		return userDAO.findAll(column);
	}

	@Override
	public User create(String Avatar, String UserName, String Password, String Email) {
		User newUser = new User();
		newUser.setUserName(UserName);
		newUser.setAvatar(Avatar);
		newUser.setEmail(Email);
		newUser.setIsAdmin(Boolean.FALSE);
		newUser.setIsActive(Boolean.TRUE);
		newUser.setPassword(Password);
		return userDAO.create(newUser);
	}

	@Override
	public User update(User Entity) {
		return userDAO.update(Entity);
	}

	@Override
	public User delete(String UserName) {
		User user = userDAO.findBy_UserName(UserName);
		user.setIsActive(Boolean.FALSE);
		return userDAO.update(user);
	}

	@Override
	public List<UserDto> finUserLikedByVideoHref(String href) {
		Map<String, Object> params = new HashMap<>();
		params.put(NameParameter.VIDEO_HREF, href);
		List<User> users =  userDAO.finUserLikedByVideoHref(params);
		List<UserDto> result = new ArrayList<>();
		users.forEach(user -> {
			UserDto userDto = new UserDto();
			userDto.setUserName(user.getUserName());
			userDto.setEmail(user.getEmail());
			result.add(userDto);
		});
		return result;
	}

}
