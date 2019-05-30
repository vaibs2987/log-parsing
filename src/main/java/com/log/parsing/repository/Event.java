package com.log.parsing.repository;

import java.util.Date;
import java.util.Map;

import com.log.model.LogDetail;

public interface Event {
	/**
	 * This method used for adding the logType in there respective maps.
	 * 
	 * @param logDetail
	 */
	public void add(LogDetail logDetail);

	/**
	 * This method will return respective map.
	 * 
	 * @return
	 */
	public Map<Date, String> getMap();

	/**
	 * This method is responsible to cleaning the key ie removed the keys which have
	 * passes the TTL.
	 */
	public void cleanMap();

	/**
	 * This method is responsible for checking the respective map for raising the
	 * notification event.
	 * 
	 * @return
	 */
	public boolean isNotificationAllowed();
}
