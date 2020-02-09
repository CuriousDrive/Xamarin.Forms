package com.org.panthers.service;

import java.io.IOException;

import com.org.panthers.business.busConstant;
import com.org.panthers.framework.busUtil;

public class TestService {

	public static void main(String[] args) throws IOException {
		
		new busUtil().sendEmail("fahadmullaji@gmail.com","Welcome to CurioussBox",busConstant.WelcomeNewUserTemplate, null);
	}
}
