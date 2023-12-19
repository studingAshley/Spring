package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

@Service
public class MServiceImpl implements MService {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public MemberDto login(String id, String pw) {

		MemberDto mdto = mapper.login(id,pw);
		return mdto;
	}

}
