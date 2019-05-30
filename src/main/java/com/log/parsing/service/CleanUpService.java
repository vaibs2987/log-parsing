package com.log.parsing.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CleanUpService {

	@Value("${log.threshold.time.limit}")
	private int thresholdTimeLimit;

	@Value("${log.threshold.limit}")
	private int thresholdLimit;

	/**
	 * This method is responsible for deleting keys which have passed the TTL.
	 * 
	 * @param map
	 */
	public void cleanMap(Map<Date, String> map) {
		Long currentDate = new Date().getTime();
		for (Date key : map.keySet()) {
			if ((currentDate - key.getTime()) > thresholdTimeLimit) {
				System.out.println("Deleting the key:" + key);
				map.remove(key, map.get(key));
			}
		}
	}

	/**
	 * This method is responsible to check the map that critical condition is
	 * occurred or not
	 * 
	 * @param map
	 * @return
	 */
	public boolean isRaiseFlag(Map<Date, String> map) {
		if (map.size() < thresholdLimit) {
			return false;
		}
		Long date = new Date().getTime();
		Long behindDate = date - thresholdTimeLimit * 1000;
		int counter = 0;
		for (Date key : map.keySet()) {
			if (key.getTime() >= behindDate) {
				counter++;
			}

			if (counter == thresholdLimit) {
				return true;
			}
		}

		return false;
	}
}
