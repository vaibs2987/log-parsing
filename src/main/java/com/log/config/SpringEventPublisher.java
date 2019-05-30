package com.log.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.log.event.LogEvent;
import com.log.parsing.repository.Event;

/**
 * 
 * This class is responsible for raising the event using ApplicationEvent.
 *
 */
@Component
public class SpringEventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void publishEvent(final Event event, final Long userId, final String logType) {
		System.out.println("Publishing the event. ");
		LogEvent logEvent = new LogEvent(this, event, userId, logType);
		applicationEventPublisher.publishEvent(logEvent);
	}
}
