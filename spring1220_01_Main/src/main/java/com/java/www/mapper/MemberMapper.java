package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto doLogin(String id, String pw);

	MemberDto login(String id, String pw);

	MemberDto idCheck(String id);

}
