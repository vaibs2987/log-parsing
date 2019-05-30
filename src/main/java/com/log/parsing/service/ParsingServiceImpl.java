package com.log.parsing.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.log.model.LogDetail;

@Service
public class ParsingServiceImpl implements ParsingService {

	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

	@Override
	public LogDetail parseString(String input) {
		if (StringUtils.isEmpty(input)) {
			return null;
		}
		String[] array = input.split(" ");
		if (array.length != 4) {
			return null;
		}
		Date date = parseDate(array[0], array[1]);
		LogDetail logDetail = null;
		if (date != null) {
			logDetail = new LogDetail();
			logDetail.setTimeStamp(date);
			logDetail.setLogType(array[2]);
		}
		return logDetail;
	}

	private Date parseDate(String date, String time) {
		String dateStr = date + " " + time;
		try {
			return dateFormatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
