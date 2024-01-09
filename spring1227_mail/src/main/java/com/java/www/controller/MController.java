package com.java.www.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.EmailService;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {

	@Autowired MService mService;
	@Autowired HttpSession session;
	@Autowired EmailService emailService;
	
	@GetMapping("id")
	public String id(String id, String email, Model model) {
		
		model.addAttribute("id",id);
		
		return "member/id";
	}
	@GetMapping("idsearch")
	public String idsearch() {
		return "member/idsearch";
	}
	
	@GetMapping("step01")
	public String step01() {
		return "member/step01";
	}
	
	@GetMapping("step02")
	public String step02() {
		return "member/step02";
	}
	 
	
	@PostMapping("email")
	@ResponseBody
	public JSONObject email(String email) {
		System.out.println("MController email : "+email);
		String result ="";
		JSONObject jObj = new JSONObject();
		MemberDto mdto = mService.emailDuplication(email);
		
		if(mdto==null)
		{
			result = emailService.mailSend(email);//service연결 - 이메일주소 보냄.
			
			session.setAttribute("session_code", result);
			System.out.println(session.getAttribute("session_code"));
			jObj.put("result","사용가능");
			jObj.put("email", email);
		}
		else
		{
			jObj.put("result","사용불가");
		}
		
		return jObj;
	}
	
	
	
	
	@PostMapping("codeCheck")
	@ResponseBody
	public String codeCheck(String code) {

		String result ="";
		
		String originalCode = session.getAttribute("session_code").toString();
		
		if(code.equals(originalCode))
		{
			result="성공";
			//System.out.println("originalCode : "+originalCode);
			session.invalidate();
			session.setAttribute("session_status", "success");
		}

		return result;
	}
	
	@PostMapping("idMailCheck")
	@ResponseBody
	public JSONObject idMailCheck(String name, String email)
	{	
		String tempId ="";
		String isSuccess="실패";
		System.out.println("MController idMailCheck id : "+name);
		System.out.println("MController idMailCheck email : "+ email);
		
		MemberDto mdto =  mService.idMailCheck(name,email);
		if(mdto != null)
		{
			isSuccess = "성공";
			String result = emailService.idMailSend(mdto.getId(), email);
			tempId = mdto.getId().substring(0,mdto.getId().length()-2);
			System.out.println("mdto.getId().length() : " + mdto.getId().length());
			tempId = tempId +"**";
			
		}

		
		JSONObject jObj = new JSONObject();
		jObj.put("result", isSuccess);
		jObj.put("tempId", tempId);
		
		return jObj;
	}
	
	
	//---- login부분 ----
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	
	//------ 로그인 확인 부분 ----------
	//------ ajax 형태 ----------
	@PostMapping("ajaxLogin")
	@ResponseBody //데이터 전송
	public String ajaxLogin(MemberDto mdto) {
		System.out.println("MController login id : "+mdto.getId());
		System.out.println("MController login pw : "+mdto.getPw());
		
		//service연결 - 1:성공,0:실패
		int result = mService.login(mdto);
		System.out.println("MController login result : "+result);
		
		return result+"";
	}
	
	//------ jsp 형태 ----------
	@PostMapping("login")
	public String login(MemberDto mdto,Model model) {
		System.out.println("MController login id : "+mdto.getId());
		System.out.println("MController login pw : "+mdto.getPw());
		
		//service연결 - 1:성공,0:실패
		int result = mService.login(mdto);
		//model전송
		model.addAttribute("result",result);
		System.out.println("MController login result : "+result);
		return "member/doLogin";
	}
}
