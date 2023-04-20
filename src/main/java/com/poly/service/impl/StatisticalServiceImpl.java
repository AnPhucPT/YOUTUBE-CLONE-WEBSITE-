package com.poly.service.impl;

import java.util.List;

import com.poly.Dto.VideoLiked;
import com.poly.dao.StatisticalDAO;
import com.poly.dao.impl.StatisticalDAOImpl;
import com.poly.service.StatisticalService;

public class StatisticalServiceImpl implements StatisticalService {
	private StatisticalDAO statisticalDAO;

	public StatisticalServiceImpl() {
		statisticalDAO = new StatisticalDAOImpl();
	}

	@Override
	public List<VideoLiked> find_VideoLike() {
		return statisticalDAO.find_VideoLike() ;
	}

}
