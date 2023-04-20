package com.poly.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.poly.Dto.VideoLiked;
import com.poly.dao.AbstractDAO;
import com.poly.dao.StatisticalDAO;

public class StatisticalDAOImpl extends AbstractDAO<Object[]> implements StatisticalDAO {

	@Override
	public List<VideoLiked> find_VideoLike() {
		String sql = "SELECT v.ID, v.Title, v.Href, SUM(CAST(h.isLike AS INT)) AS TotalLike"
				+ " FROM Video v LEFT JOIN UserHistory h ON v.ID = h.VideoID"
				+ " WHERE v.isActive = 1"
				+ " GROUP BY v.ID, v.Title, v.Href "
				+ " ORDER BY SUM(CAST(h.isLike AS INT)) DESC";
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<VideoLiked> result = new ArrayList<> ();
		objects.forEach(object -> {
			VideoLiked videdLiked = setData_VideoLiked(object);
			result.add(videdLiked);
		});
		return result;
	}
	
	private VideoLiked setData_VideoLiked (Object[] object) {
		VideoLiked videoLiked = new VideoLiked();
		videoLiked.setVideoID((Integer)object[0]);
		videoLiked.setTitle((String)object[1]);
		videoLiked.setHref((String)object[2]);
		videoLiked.setTotalLike((Integer)object[3] == null ? 0 : (Integer)object[3]);
		return videoLiked;
	}


}
