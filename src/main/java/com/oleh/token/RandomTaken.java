package com.oleh.token;

import org.apache.commons.lang.RandomStringUtils;

public class RandomTaken {

	public static String generateToken() {
		return RandomStringUtils.randomAlphanumeric(50);
	}
}
