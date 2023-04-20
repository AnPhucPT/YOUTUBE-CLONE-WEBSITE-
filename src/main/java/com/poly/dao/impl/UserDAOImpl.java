package com.poly.dao.impl;

import java.util.List;
import java.util.Map;

import com.poly.constant.NamedStored;
import com.poly.dao.AbstractDAO;
import com.poly.dao.UserDAO;
import com.poly.entity.User;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

	@Override
	public User findBy_ID(Integer ID) {
		return super.findById(User.class, ID);
	}

	@Override
	public User findBy_Email(String Email) {
		String jpql = "SELECT o FROM User o WHERE o.Email = ?0";
		return super.findOne(User.class, jpql, Email);
	}

	@Override
	public User findBy_UserName(String UserName) {
		String jpql = "SELECT o FROM User o WHERE o.UserName = ?0";
		return super.findOne(User.class, jpql, UserName);
	}

	@Override
	public User findBy_UserName_And_Password(String UserName, String Password) {
		String jpql = "SELECT o FROM User o WHERE o.UserName = ?0 AND o.Password = ?1";
		
		return super.findOne(User.class, jpql, UserName, Password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}
	
	@Override
	public List<User> findAll(String column) {
		return super.findAll(User.class, true, true, column);
	}
	
	@Override
	public List<User> findAll(int PageNumber, int PageSize) {
		return super.findAll(User.class, true, PageNumber, PageSize);
	}

	@Override
	public User create(User Entity) {
		return super.create(Entity);
	}

	@Override
	public User update(User Entity) {
		return super.update(Entity);
	}

	@Override
	public User delete(User Entity) {
		return super.delete(Entity);
	}

	@Override
	public List<User> finUserLikedByVideoHref(Map<String, Object> params) {
		return super.callStore(NamedStored.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF, params);
	}

	

}
