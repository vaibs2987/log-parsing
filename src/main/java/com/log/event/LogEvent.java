package com.log.event;

import org.springframework.context.ApplicationEvent;

import com.log.parsing.repository.Event;

/**
 * 
 * This is a event which will triggered when we get the input string.
 *
 */
public class LogEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private final Event event;
	private final Long userId;
	private final String logType;

	public LogEvent(Object source, Event event, Long userId, String logType) {
		super(source);
		this.event = event;
		this.userId = userId;
		this.logType = logType;
	}

	public Event getEvent() {
		return event;
	}

	public Long getUserId() {
		return userId;
	}

	public String getLogType() {
		return logType;
	}

}
