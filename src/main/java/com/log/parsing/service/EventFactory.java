package com.log.parsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.log.model.LogDetail;
import com.log.model.LogType;
import com.log.parsing.repository.BlockerLogRepository;
import com.log.parsing.repository.CriticalLogRepository;
import com.log.parsing.repository.Event;
import com.log.parsing.repository.InfoLogRepository;
import com.log.parsing.repository.WarningLogRepository;

/**
 * Factory class for returning the respective repository.
 * 
 *
 */
@Component
public class EventFactory {

	@Autowired
	private CriticalLogRepository criticalLogRepository;

	@Autowired
	private WarningLogRepository warningLogRepository;

	@Autowired
	private BlockerLogRepository blockerLogRepository;

	@Autowired
	private InfoLogRepository infoLogRepository;

	public Event getRepository(LogDetail logDetail) {
		LogType logType = LogType.getLogType(logDetail.getLogType());

		if (logType == null) {
			return null;

		}
		switch (logType) {
		case INFO:
			return infoLogRepository;
		case CRITICAL:
			return criticalLogRepository;
		case WARNINNG:
			return warningLogRepository;
		case BLOCKER:
			return blockerLogRepository;
		default:
			break;
		}
		return null;
	}
}
