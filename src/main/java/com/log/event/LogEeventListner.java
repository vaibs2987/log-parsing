package com.log.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.log.parsing.repository.Event;
import com.log.user.service.UserNotificationService;

/**
 * 
 * This is the listener which listening to LogEvent event.
 *
 */
@Component
public class LogEeventListner implements ApplicationListener<LogEvent> {

	@Autowired
	private UserNotificationService userNotificationService;

	@Override
	public void onApplicationEvent(LogEvent logEvent) {
		Event event = logEvent.getEvent();
		Long userId = logEvent.getUserId();
		String logType = logEvent.getLogType();
		if (event.isNotificationAllowed()) {
			System.out.println("Notifications has to send");
			userNotificationService.sendNotification(userId, logType);
		}
		event.cleanMap();
	}

}
