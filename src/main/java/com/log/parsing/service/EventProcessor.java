package com.log.parsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.log.config.SpringEventPublisher;
import com.log.model.LogDetail;
import com.log.parsing.repository.Event;

@Component
public class EventProcessor {

	@Autowired
	private ParsingService parsingService;

	@Autowired
	private EventFactory eventFactory;

	@Autowired
	private SpringEventPublisher springEventPublisher;

	/**
	 * This method is the entry point.
	 * 
	 * @param input
	 * @param userId
	 */
	public void process(String input, Long userId) {
		LogDetail logDetail = parsingService.parseString(input);
		if (logDetail == null) {
			return;
		}
		Event event = eventFactory.getRepository(logDetail);
		event.add(logDetail);
		springEventPublisher.publishEvent(event, userId, logDetail.getLogType());
	}
}
