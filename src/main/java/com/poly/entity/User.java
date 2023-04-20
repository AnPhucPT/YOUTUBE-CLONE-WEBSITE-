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
		@NamedStoredProcedureQuery(name = NamedStored.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF, procedureName = "SP_SelectUserLikedVideoByVideoHref", resultClasses = {
				User.class }, parameters = @StoredProcedureParameter(name = NameParameter.VIDEO_HREF, type = String.class)) })

@Entity
@Table(name = "`User`")
public class User {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;

	@Column(name = "Avatar")
	private String Avatar;

	@Column(name = "UserName")
	private String UserName;

	@Column(name = "Password")
	private String Password;

	@Column(name = "Email")
	private String Email;

	@Column(name = "isAdmin")
	private Boolean isAdmin;

	@Column(name = "isActive")
	private Boolean isActive;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
