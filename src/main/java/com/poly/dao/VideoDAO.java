package com.poly.dao;

import java.util.List;
import java.util.Map;

import com.poly.entity.User;
import com.poly.entity.Video;

public interface VideoDAO {
	Video findBy_ID (Integer ID);
	Video findBy_Href(String Href);
	List <Video> findAll();
	List <Video> findAll(String column);
	List <Video> findAll(int PageNumber, int PageSixe);
	List <Video> findAll(int PageNumber, int PageSixe, String column);
	Video create(Video Entity);
	Video update(Video Entity);
	Video delete(Video Entity);
	
	List <Video> findRandomVideo(Map<String, Object> params);
}
