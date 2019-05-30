package com.log.model;

import java.util.Date;

/**
 * 
 * Model class responsible to hold the user notification subscription. This can
 * be persist in some database and based on scale it in can be persisted in memory
 * store like redis. UserId will key and value will be
 * UserNotificationPreference object.
 */
public class UserNotificationPreference {

	private Long id;
	private Long userId;
	private LogType logType;
	private boolean isEmailSubscribed;
	private boolean isSmsSubscribed;
	private boolean isPushSubscribed;

	private Date createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	public boolean isEmailSubscribed() {
		return isEmailSubscribed;
	}

	public void setEmailSubscribed(boolean isEmailSubscribed) {
		this.isEmailSubscribed = isEmailSubscribed;
	}

	public boolean isSmsSubscribed() {
		return isSmsSubscribed;
	}

	public void setSmsSubscribed(boolean isSmsSubscribed) {
		this.isSmsSubscribed = isSmsSubscribed;
	}

	public boolean isPushSubscribed() {
		return isPushSubscribed;
	}

	public void setPushSubscribed(boolean isPushSubscribed) {
		this.isPushSubscribed = isPushSubscribed;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
