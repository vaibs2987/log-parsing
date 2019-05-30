package com.log.parsing.repository;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log.model.LogDetail;
import com.log.parsing.service.CleanUpService;

@Repository
public class CriticalLogRepository implements Event {

	private Map<Date, String> criticalMap = Collections.synchronizedMap(new LinkedHashMap<Date, String>());

	@Autowired
	private CleanUpService cleanUpService;

	@Override
	public void add(LogDetail logDetail) {
		criticalMap.put(logDetail.getTimeStamp(), logDetail.getLogType());

	}

	@Override
	public Map<Date, String> getMap() {
		return criticalMap;
	}

	@Override
	public void cleanMap() {
		cleanUpService.cleanMap(criticalMap);
	}
	
	@Override
	public boolean isNotificationAllowed() {
		return cleanUpService.isRaiseFlag(getMap());
	}
}
