package com.log.user.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader.InvalidCacheLoadException;
import com.google.common.cache.LoadingCache;

/**
 * 
 * This class hold locking part logic. Currently I am storing in Guava Map, if
 * we are running on distributed node then this lock should be outside the code.
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Value("${log.threshold.time.limit}")
	private int thresholdTimeLimit;

	private LoadingCache<String, String> userMap = CacheBuilder.newBuilder()
			.expireAfterAccess(thresholdTimeLimit, TimeUnit.MILLISECONDS).build(new CacheLoader<String, String>() {

				@Override
				public String load(String empId) throws Exception {
					return getFromMap(empId);
				}
			});

	private String getFromMap(String key) {
		Map<String, String> map = userMap.asMap();
		return map.get(key);
	}

	public void addValue(String key, String logType) {
		userMap.put(key, logType);

	}

	public boolean isKeyExists(String key) {
		try {
			return userMap.get(key) != null;
		} catch (ExecutionException | InvalidCacheLoadException e) {
		}
		return false;
	}

}
