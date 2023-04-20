package com.poly.service;

import java.util.List;
import java.util.Map;

import com.poly.entity.Video;

public interface VideoService {
	Video findBy_ID (Integer ID);
	Video findBy_Href(String Href);
	List <Video> findAll();
	List <Video> findAll(String column);
	List <Video> findAll(int PageNumber, int PageSixe);
	List <Video> findAll(int PageNumber, int PageSixe, String column);
	Video create(Video Entity);
	Video update(Video Entity);
	Video delete(String Href);
	
	List <Video> findRandomVideo(String href, int NumberRandom);
}
