package com.poly.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.poly.dao.HistoryDAO;
import com.poly.dao.impl.HistoryDAOImpl;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;

public class HistoryServiceImpl implements HistoryService {

	private HistoryDAO historyDAO;
	private VideoService videoService = new VideoServiceImpl();

	public HistoryServiceImpl() {
		historyDAO = new HistoryDAOImpl();
	}

	@Override
	public List<History> findBy_UserName(String UserName) {
		return historyDAO.findBy_UserName(UserName);
	}

	@Override
	public List<History> findBy_UserName_And_IsLiked(String UserName) {
		return historyDAO.findBy_UserName_And_IsLiked(UserName);
	}

	@Override
	public History findBy_UserID_And_VideoID(Integer UserID, Integer VideoID) {
		return historyDAO.findBy_UserID_And_VideoID(UserID, VideoID);
	}

	@Override
	public History create(User user, Video video) {
		History existHistory = findBy_UserID_And_VideoID(user.getID(), video.getID());
		if(existHistory == null) {
			video.setViews(video.getViews() + 1);
			videoService.update(video);
			existHistory = new History();
			existHistory.setUser(user);
			existHistory.setVideo(video);
			existHistory.setViewedDate(new Timestamp(System.currentTimeMillis()));
			existHistory.setIsLike(Boolean.FALSE);
			return historyDAO.create(existHistory);
		}
		return existHistory;
		
	}

	@Override
	public Boolean update_LikeOrUnlike(User user, String videoHref) {
		Video video = videoService.findBy_Href(videoHref);
		History existHistory = findBy_UserID_And_VideoID(user.getID(), video.getID());

		if (existHistory.getIsLike() == Boolean.FALSE) {
			video.setLikes(video.getLikes()+1);
			videoService.update(video);
			
			existHistory.setIsLike(Boolean.TRUE);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		} else {
			video.setLikes(video.getLikes()-1);
			videoService.update(video);
			
			existHistory.setIsLike(Boolean.FALSE);
			existHistory.setLikedDate(null);
		}
		History updateHistory = historyDAO.update(existHistory);
		return updateHistory != null ? true : false;
	}

}
