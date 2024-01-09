package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;

	@Override
	public String logincheck(MemberDto mdto) {

		MemberDto dto = mapper.loginCheck(mdto);
		mdto.setName(dto.getName());
		String result="fail";
		if(dto!= null)
		{
			result="success";
		}
		return result;
	}

	@Override
	public String duplCheck(String id) {
		String result = "useable";
		
		String idresult = mapper.duplCheck(id);
		
		System.out.println("idresult : "+idresult);
		
		if(idresult!=null)
		{
			result ="duplication";
		}
		return result;
	}

}
