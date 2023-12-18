package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MService{

	@Autowired
	MemberMapper mapper;
	
	@Override
	public MemberDto loginSelect(MemberDto mdto) {
		
		MemberDto memberdto = mapper.loginSelect(mdto);
		
		return memberdto;
	}

}
