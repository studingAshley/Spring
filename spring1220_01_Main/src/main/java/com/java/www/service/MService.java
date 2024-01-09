package com.java.www.service;



import com.java.www.dto.MemberDto;


public interface MService {

	MemberDto doLogin(String id, String pw);

	int login(String id, String pw);

	String idcheck(String id);

}
