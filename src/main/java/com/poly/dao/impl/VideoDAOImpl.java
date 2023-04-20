package com.poly.dao.impl;

import java.util.List;
import java.util.Map;

import com.poly.constant.NamedStored;
import com.poly.dao.AbstractDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Video;

public class VideoDAOImpl extends AbstractDAO<Video> implements VideoDAO {

	@Override
	public Video findBy_ID(Integer ID) {
		return super.findById(Video.class, ID);
	}

	@Override
	public Video findBy_Href(String Href) {
		String jpql = "SELECT o FROM Video o WHERE o.Href = ?0";
		return super.findOne(Video.class, jpql, Href);
	}
	
	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}
	
	@Override
	public List<Video> findAll(String column) {
		return super.findAll(Video.class, true, true, column);
	}
	

	@Override
	public List<Video> findAll(int PageNumber, int PageSixe) {
		return super.findAll(Video.class, true, PageNumber, PageSixe);
	}
	
	@Override
	public List<Video> findAll(int PageNumber, int PageSixe, String column) {
		return super.findAll(Video.class, true, PageNumber, PageSixe, true, column);
	}

	@Override
	public Video create(Video Entity) {
		return super.create(Entity);
	}

	@Override
	public Video update(Video Entity) {
		return super.update(Entity);
	}

	@Override
	public Video delete(Video Entity) {
		return super.delete(Entity);
	}

	@Override
	public List<Video> findRandomVideo(Map<String, Object> params) {
		return super.callStore(NamedStored.FIND_RANDOM_VIDEO, params);
	}

	

	

	

}
