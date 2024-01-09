package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService service;
	
	@Autowired
	HttpSession session;

	@RequestMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(MemberDto memberDto,Model model)
	{
		int result = 0;
		
		MemberDto mdto = service.login(memberDto);
		
		if(mdto != null)
		{
		
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
			result=1;
		}
		else
		{
			result=0;
		}
		
		model.addAttribute("result",result);
		return "member/doLogin";
	}
}
