package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.MemberService;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired com.java.www.service.MemberService service;
	
	@Autowired HttpSession session;
	
	@GetMapping("login")
	public String login()
	{
		return "member/login";
	}	
	
	@PostMapping("/member/loginCheck")
	@ResponseBody
	public MemberDto loginCheck(MemberDto mdto) {

			System.out.println(mdto.getId());
			
	//		MemberDto memberDto = serv.loginCheck(mdto);
			
		//return memberDto;
			return null;
	}
	
	
}
