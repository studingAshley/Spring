package com.java.www.service;

import com.java.www.dto.MemberDto;

public interface MService {

	//로그인 확인
	int login(MemberDto mdto);

	MemberDto idMailCheck(String name, String email);

	MemberDto emailDuplication(String email);

}
