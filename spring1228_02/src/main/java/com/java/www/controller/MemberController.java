package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@Autowired HttpSession httpSession;
	
	@GetMapping("login")
	public String login()
	{
			
		return "member/login";
	}
	
	@PostMapping("/member/loginCheck")
	@ResponseBody
	public String loginCheck(MemberDto mdto) {

		System.out.println("mdto id pw : "+mdto.getId() + mdto.getPw());
		String result = service.logincheck(mdto);
		
		if(result.equals("success"))
		{
			httpSession.setAttribute("session_id", mdto.getId());
			httpSession.setAttribute("session_name", mdto.getName());
		}
		
		return result;
	}
	
	@GetMapping("logout")
	public String logout() {
		httpSession.invalidate();
		
		return "../";
	}
	
	@GetMapping("step01")
	public String step01() {

		
		return "member/step01";
	}
	
	@GetMapping("step02")
	public String step02() {

		return "member/step02";
	}
	
	@GetMapping("step03")
	public String step03() {

		return "member/step03";
	}
	
	@GetMapping("step04")
	public String step04() {

		return "member/step04";
	}
	
	@PostMapping("duplCheck")
	@ResponseBody
	public String duplCheck(String id)
	{
		System.out.println("ID : " + id);
		String result = service.duplCheck(id);

		
		return result;
	}
	

}
