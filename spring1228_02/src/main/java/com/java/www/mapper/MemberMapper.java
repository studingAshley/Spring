package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto loginCheck(MemberDto mdto);

	String duplCheck(String id);

}
