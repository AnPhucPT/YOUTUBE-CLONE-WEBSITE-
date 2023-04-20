package com.poly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.Dto.UserDto;
import com.poly.constant.NameParameter;
import com.poly.dao.VideoDAO;
import com.poly.dao.impl.VideoDAOImpl;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.VideoService;

public class VideoServiceImpl implements VideoService {

	private VideoDAO videoDAO;

	public VideoServiceImpl() {
		videoDAO = new VideoDAOImpl();
	}

	@Override
	public Video findBy_ID(Integer ID) {
		return videoDAO.findBy_ID(ID);
	}

	@Override
	public Video findBy_Href(String Href) {
		return videoDAO.findBy_Href(Href);
	}

	@Override
	public List<Video> findAll() {
		return videoDAO.findAll();
	}
	
	@Override
	public List<Video> findAll(String column) {
		return videoDAO.findAll(column);
	}
	

	@Override
	public List<Video> findAll(int PageNumber, int PageSixe) {
		return videoDAO.findAll(PageNumber, PageSixe);
	}
	
	@Override
	public List<Video> findAll(int PageNumber, int PageSixe, String column) {
		return videoDAO.findAll(PageNumber, PageSixe, column);
	}

	@Override
	public Video create(Video Entity) {
		Entity.setIsActive(Boolean.TRUE);
		Entity.setViews(0);
		Entity.setShares(0);
		Entity.setLikes(0);
		return videoDAO.create(Entity);
	}

	@Override
	public Video update(Video Entity) {
		return videoDAO.update(Entity);
	}

	@Override
	public Video delete(String Href) {
		Video Entity = videoDAO.findBy_Href(Href);
		Entity.setIsActive(Boolean.FALSE); 
		return videoDAO.update(Entity);
	}

	@Override
	public List<Video> findRandomVideo(String href, int NumberRandom) {
		Map<String, Object> params = new HashMap<>();
		params.put(NameParameter.VIDEO_HREF, href);
		params.put(NameParameter.NUMBER_RANDOM, NumberRandom);
		List<Video> videos =  videoDAO.findRandomVideo(params);
		return videos;
	}

	

	

	

}
