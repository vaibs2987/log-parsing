package com.log.parsing.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.log.model.LogDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParsingServiceTest {

	@Autowired
	private ParsingService parsingService;

	@Test
	public void testParseString() {
		LogDetail logDetail = parsingService.parseString("2019-01-07 14:52:33 Warning data");
		assertTrue(logDetail != null);
		assertTrue(logDetail.getTimeStamp() != null);
	}

}
