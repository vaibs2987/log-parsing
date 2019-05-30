package com.log.user.service;

public interface UserService {

	/**
	 * This method add a key in Map with configured TTL.
	 * 
	 * @param key
	 * @param logType
	 */
	public void addValue(String key, String logType);

	/**
	 * This method will check whether key is present or not.
	 * 
	 * @param key
	 * @return
	 */
	public boolean isKeyExists(String key);
}
