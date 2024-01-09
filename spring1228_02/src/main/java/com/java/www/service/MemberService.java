package com.java.www.service;

import com.java.www.dto.MemberDto;

public interface MemberService {

	String logincheck(MemberDto mdto);

	String duplCheck(String id);

}
