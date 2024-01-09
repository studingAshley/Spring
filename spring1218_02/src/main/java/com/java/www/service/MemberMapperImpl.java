package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

@Service
public class MemberMapperImpl implements MService {

	@Autowired
	MemberMapper mapper;
	
	public MemberDto login(MemberDto mdto)
	{
		MemberDto memberDto = mapper.login(mdto);
		return memberDto;
	}
}
