package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.AbstractDAO;
import com.poly.dao.HistoryDAO;
import com.poly.entity.History;

@SuppressWarnings("rawtypes")
public class HistoryDAOImpl extends AbstractDAO implements HistoryDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<History> findBy_UserName(String UserName) {
		String jpql = "SELECT o FROM History o" + " WHERE o.user.UserName = ?0" + " AND o.video.isActive = 1"
				+ " ORDER BY o.ViewedDate DESC";
		return super.findMany(History.class, jpql, UserName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> findBy_UserName_And_IsLiked(String UserName) {
		String jqpl = "SELECT o FROM History o" + " WHERE o.user.UserName = ?0" + " AND o.isLike = 1"
				+ " ORDER BY o.ViewedDate DESC";
		return super.findMany(History.class, jqpl, UserName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public History findBy_UserID_And_VideoID(Integer UserID, Integer VideoID) {
		String jpql = "SELECT o FROM History o" + " WHERE o.user.ID = ?0" + " AND o.video.ID = ?1"
				+ " AND o.video.isActive = 1";
		return (History) super.findOne(History.class, jpql, UserID, VideoID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public History create(History Entity) {
		return (History) super.create(Entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public History update(History Entity) {
		return (History) super.update(Entity);
	}

}
