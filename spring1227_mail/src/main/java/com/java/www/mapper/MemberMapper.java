package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {

	//로그인 확인
	MemberDto login(MemberDto mdto);

	MemberDto idMailCheck(String  name, String email);

	MemberDto emailCheck(String email);

	
}
