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
public class BlockerLogRepository implements Event {

	private Map<Date, String> blockerMap = Collections.synchronizedMap(new LinkedHashMap<Date, String>());

	@Autowired
	private CleanUpService cleanUpService;

	@Override
	public void add(LogDetail logDetail) {
		blockerMap.put(logDetail.getTimeStamp(), logDetail.getLogType());

	}

	@Override
	public Map<Date, String> getMap() {
		return blockerMap;
	}

	@Override
	public void cleanMap() {
		cleanUpService.cleanMap(blockerMap);
	}

	@Override
	public boolean isNotificationAllowed() {
		return cleanUpService.isRaiseFlag(getMap());
	}
}
