package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MService serv;
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("login")
	public String login()
	{
		return "login";
	}
	
	@PostMapping("doLogin")
	public String doLogin(String id, String pw, Model model)
	{
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		MemberDto mdto = serv.login(id,pw);
		
		if(mdto!=null)
		{
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}
		
		
		return "index";
	}
	
	@GetMapping("logout")
	public String logout()
	{
		
		session.invalidate();
		return "index";
	}
}