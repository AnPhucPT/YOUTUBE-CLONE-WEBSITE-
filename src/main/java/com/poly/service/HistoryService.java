package com.poly.service;

import java.util.List;

import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;

public interface HistoryService {
	List<History> findBy_UserName(String UserName);

	List<History> findBy_UserName_And_IsLiked(String UserName);

	History findBy_UserID_And_VideoID(Integer UserID, Integer VideoID);

	History create(User user, Video video);

	Boolean update_LikeOrUnlike(User user, String videoHref);
}
