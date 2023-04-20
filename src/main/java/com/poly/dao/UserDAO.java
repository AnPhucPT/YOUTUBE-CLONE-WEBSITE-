package com.poly.dao;

import java.util.List;
import java.util.Map;

import com.poly.entity.User;

public interface UserDAO {
	User findBy_ID(Integer ID);
	User findBy_Email(String Email);
	User findBy_UserName(String UserName);
	User findBy_UserName_And_Password(String UserName, String Password);
	List <User> findAll();
	List <User> findAll(String column);
	List <User> findAll(int PageNumber, int PageSize);
	User create (User Entity);
	User update (User Entity);
	User delete (User Entity);
	
	List <User> finUserLikedByVideoHref(Map<String, Object> params);
}
