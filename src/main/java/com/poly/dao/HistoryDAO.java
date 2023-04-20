package com.poly.dao;

import java.util.List;

import com.poly.entity.History;

public interface HistoryDAO {
	List<History> findBy_UserName(String UserName);

	List<History> findBy_UserName_And_IsLiked(String UserName);

	History findBy_UserID_And_VideoID(Integer UserID, Integer VideoID);

	History create(History Entity);

	History update(History ENtity);
}
