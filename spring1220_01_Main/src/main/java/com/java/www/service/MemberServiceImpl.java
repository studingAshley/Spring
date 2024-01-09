package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MService {

	@Autowired
	MemberMapper mapper;
	@Autowired
	HttpSession session;
	
	@Override
	public MemberDto doLogin(String id, String pw) {
		System.out.println("doLogin id : "+ id);
		MemberDto mdto = mapper.login(id, pw);
		return mdto;
	}

	@Override
	public int login(String id, String pw) {
		int result = 0;
		MemberDto mdto = mapper.doLogin(id, pw);
		
		if(mdto !=null)
		{
			result=1;
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}
		
		return result;
	}

	@Override
	public String idcheck(String id) {
		String result = "Inavaliable";
		
		MemberDto mdto =  mapper.idCheck(id);
		
		if(mdto==null)
		{
			result = "Available";
		}
		
		
		return result;
	}

}
