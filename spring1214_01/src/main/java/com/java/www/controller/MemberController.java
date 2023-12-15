package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;

@Controller
//@RequestMapping("member")
public class MemberController {
	
	@RequestMapping("mInsert")
	public String mInsert() {
		System.out.println("mInsert");
		return "member/mInsert";
	}
	
	@RequestMapping("doMInsert")
	public String doMInsert(MemberDto mdto, Model model) {
		

		
		model.addAttribute("mdto",mdto);
		
		return "member/memberView";
	}
	
	
	@RequestMapping("mUpdate")
	public String mUpdate(MemberDto mdto, Model model) {
		
	 model.addAttribute("mdto",mdto);
			
		return "member/memberUpdate";
	}
	
	@RequestMapping("doMUpdate")
	public String doMUpdate(MemberDto mdto, Model model) {
		

		System.out.println("doMUpdate name : " + mdto.getName() );
		
		model.addAttribute("mdto",mdto);
		return "member/memberView";
	}

	@RequestMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	@PostMapping("doLogin")
	public String doLogin( MemberDto memberDto,  BoardDto boardDto,  Model model) {


		System.out.println("id : "+ memberDto.getId());
		System.out.println("pw : "+ memberDto.getPw());
		System.out.println("boardDto.getBno() : " + boardDto.getBno());

	
		String id = memberDto.getId();
		String pw = memberDto.getPw();
		int bno = boardDto.getBno();
		
		MemberDto mdto = new MemberDto();
		mdto.setId(id);
		System.out.println("getid : " + mdto.getId());
		//전체생성자
		MemberDto mdto2 = new MemberDto(id, pw, "ghdrlfehd", "010-1111-1111", "mail","game,golf", new Timestamp(System.currentTimeMillis()));
		
		//부분생성자
		MemberDto mdto3 = MemberDto.builder().id(id).pw(pw).name("dbrhkstns").gender("female").build();
		
		System.out.println("mdto3 name : " + mdto3.getName());
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("bno",bno);
		model.addAttribute("mdto", memberDto);
		
		return "member/doLogin";
	}
}
