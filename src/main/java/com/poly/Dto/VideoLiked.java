package com.poly.Dto;

public class VideoLiked {
	private Integer videoID;
	private String title;
	private String href;
	private Integer totalLike;

	@Override
	public String toString() {
		return "VideoLike [videoID=" + videoID + ", title=" + title + ", href=" + href + ", totalLike=" + totalLike
				+ "]";
	}

	public VideoLiked() {
		super();
	}

	public VideoLiked(Integer videoID, String title, String href, Integer totalLike) {
		super();
		this.videoID = videoID;
		this.title = title;
		this.href = href;
		this.totalLike = totalLike;
	}

	public Integer getVideoID() {
		return videoID;
	}

	public void setVideoID(Integer videoID) {
		this.videoID = videoID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getTotalLike() {
		return totalLike;
	}

	public void setTotalLike(Integer totalLike) {
		this.totalLike = totalLike;
	}

}
