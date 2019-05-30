package com.log.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

	@Value("${log.threshold.time.limit}")
	private int thresholdTimeLimit;

	@Autowired
	private UserService userService;

	@Override
	public void sendNotification(Long userId, String logType) {
		boolean isKeyExists = userService.isKeyExists(userId.toString());
		if (isKeyExists) {
			try {
				System.out.println("Going to sleep");
				Thread.sleep(thresholdTimeLimit * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Adding key in userMap");
		userService.addValue(userId.toString(), logType);
		System.out.println("Send notification");
		// TODO Now find the user notification preferences firing quering on database or
		// redis. Based on that generate the notifications.
	}

}
