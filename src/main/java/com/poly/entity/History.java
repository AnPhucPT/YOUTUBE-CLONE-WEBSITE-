package com.poly.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "UserHistory", uniqueConstraints = { @UniqueConstraint(columnNames = { "VideoID", "UserID" }) })
public class History {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;

	@ManyToOne
	@JoinColumn(name = "UserID")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private User user;

	@ManyToOne
	@JoinColumn(name = "VideoID")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private Video video;

	@Column(name = "ViewedDate")
	@CreationTimestamp
	private Timestamp ViewedDate;

	@Column(name = "LikedDate")
	private Timestamp LikedDate;

	@Column(name = "isLike")
	private Boolean isLike;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public Timestamp getViewedDate() {
		return ViewedDate;
	}

	public void setViewedDate(Timestamp viewedDate) {
		ViewedDate = viewedDate;
	}

	public Timestamp getLikedDate() {
		return LikedDate;
	}

	public void setLikedDate(Timestamp likedDate) {
		LikedDate = likedDate;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Boolean getIsLike() {
		return isLike;
	}

	public void setIsLike(Boolean isLike) {
		this.isLike = isLike;
	}

}
