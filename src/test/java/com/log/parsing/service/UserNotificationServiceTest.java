package com.log.parsing.service;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.log.model.LogType;
import com.log.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserNotificationServiceTest {

	@Autowired
	private UserService userNotificationService;

	private String key = "1";

	@Before
	public void loadData() {
		userNotificationService.addValue(key, LogType.CRITICAL.name());
		userNotificationService.addValue("2", LogType.BLOCKER.name());
		userNotificationService.addValue("22", LogType.BLOCKER.name());
		userNotificationService.addValue("23", LogType.BLOCKER.name());
		userNotificationService.addValue("24", LogType.BLOCKER.name());

	}


	@Test
	public void testBIsKeyExistsFalse() {
		boolean flag = userNotificationService.isKeyExists("303");
		assertFalse(flag);
	}
}
