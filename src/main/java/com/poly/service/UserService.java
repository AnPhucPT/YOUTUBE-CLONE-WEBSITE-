package com.poly.service;

import java.util.List;

import com.poly.Dto.UserDto;
import com.poly.entity.User;

public interface UserService {
	User findBy_ID(Integer ID) ;
	User findBy_Email(String Email);
	User findBy_UserName(String UserName);
	User Login(String UserName, String Password);
	User resetPassword(String email);
	List <User> findAll();
	List <User> findAll(String column);
	List <User> findAll(int PageNumber, int PageSize);
	User create (String Avatar, String UserName, String Password, String Email);
	User update (User Entity);
	User delete (String UserName);
	
	List <UserDto> finUserLikedByVideoHref(String href);
}
