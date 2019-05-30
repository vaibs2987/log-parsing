package com.log.user.service;

public interface UserNotificationService {

	/**
	 * This method will be used to send the notifications. In this method first it
	 * will check in userMap that key is present or not. If key present then wait
	 * for the threshold limit and if not then create key in userMap and then fetch
	 * the user preferences and based on preferences notifications will be triggered.
	 * 
	 * @param userId
	 * @param logType
	 */
	public void sendNotification(Long userId, String logType);
}
