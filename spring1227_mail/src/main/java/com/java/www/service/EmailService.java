package com.java.www.service;

public interface EmailService {

	//이메일 전송
	String mailSend(String email);

	String idMailSend(String id, String email);

}
