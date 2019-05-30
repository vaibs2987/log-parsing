package com.log.parsing.service;

import com.log.model.LogDetail;

public interface ParsingService {

	/**
	 * This method is responsible for parsing the given string.
	 * 
	 * @param input
	 * @return LogDetail object
	 */
	LogDetail parseString(String input);
}
