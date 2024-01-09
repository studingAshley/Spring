package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller("member")
public class MemberController {
	
	@Autowired
	MService serv;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("login")
	public String login()
	{
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(String id, String pw, Model model)
	{
		int result = serv.login(id, pw);

		model.addAttribute("result",result);
		return "member/doLogin";
	}
	
	@PostMapping("doLogin")
	public String doLogin(String id, String pw)
	{
		System.out.println("id :"+id);
		System.out.println("pw :"+pw);
		MemberDto mdto = serv.doLogin(id,pw);

		if(mdto!=null)
		{
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}
		
		return "member/doLogin";
	}
	
	@GetMapping("logout")
	public String logout()
	{
		session.invalidate();
		return "index";
	}
	
	@GetMapping("mInsert")
	public String mInsert()
	{
		
		return "member/mInsert";
	}
	
	@ResponseBody
	@PostMapping("mInsert")
	public String mInsert(MemberDto mdto, Model model)
	{
		System.out.println("mInsert id :" + mdto.getId());
		
		return "가입완료";
	}
	
	
	@PostMapping("idCheck")
	@ResponseBody//return을 jsp 페이지가 아닌 data로 넘겨 줌 
	public String idCheck(String id)
	{
		String result = serv.idcheck(id);
		
		return result;
	}
}
