package com.poly.dao;

import java.util.List;

import com.poly.Dto.VideoLiked;
import com.poly.entity.User;

public interface StatisticalDAO {
	List <VideoLiked> find_VideoLike();
	
}
