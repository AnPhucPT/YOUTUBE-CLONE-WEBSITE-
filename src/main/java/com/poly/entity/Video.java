  package com.poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.poly.constant.NameParameter;
import com.poly.constant.NamedStored;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = NamedStored.FIND_RANDOM_VIDEO, 
				procedureName = "SP_selectRandomVideo", resultClasses = {
				Video.class }, parameters = {
						@StoredProcedureParameter(name = NameParameter.VIDEO_HREF, type = String.class),
						@StoredProcedureParameter(name = NameParameter.NUMBER_RANDOM, type = Integer.class) })

})
@Entity
@Table(name = "Video")
public class Video {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;

	@Column(name = "Title")
	private String Title;

	@Column(name = "Href")
	private String Href;

	@Column(name = "Views")
	private Integer Views;

	@Column(name = "Shares")
	private Integer Shares;

	@Column(name = "Description")
	private String Description;

	@Column(name = "isActive")
	private Boolean isActive;
	
	@Column(name = "Likes")
	private Integer Likes;
	
	public Integer getLikes() {
		return Likes;
	}

	public void setLikes(Integer likes) {
		Likes = likes;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getHref() {
		return Href;
	}

	public void setHref(String href) {
		Href = href;
	}

	public Integer getViews() {
		return Views;
	}

	public void setViews(Integer views) {
		Views = views;
	}

	public Integer getShares() {
		return Shares;
	}

	public void setShares(Integer shares) {
		Shares = shares;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
