package com.java.www.controller;

import java.util.ArrayList;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class BController {

	@Autowired
	BService bService;
	@Autowired HttpSession session;
	
	
	@GetMapping("notice")
	public String notice(Model model) {
		//page 가지고 와야함.
		
		//service연결
		ArrayList<BoardDto> list = bService.selectAll();
		
		//model전송
		model.addAttribute("list", list);
		
		
		
		
		return "customer/notice";
	}
	
	@GetMapping("notice_view")
	public String notice_view(@RequestParam(defaultValue = "1") int bno, Model model)
	{
		System.out.println("bno : notice_view : " + bno);
		Map<String, Object> map = bService.selectOne(bno);

		model.addAttribute("bdto", map.get("bdto"));
		model.addAttribute("reply", map.get("reply"));
		
		return "customer/notice_view";
	}
	
	@PostMapping("BCommentInsert")
	@ResponseBody//ajax
	public BCommentDto BCommentInsert(BCommentDto cdto, Model model) {
		System.out.println("cdto.getbno :" + cdto.getBno());
		
		BCommentDto bCommentDto = bService.bCommentInsert(cdto);
		
		
		return bCommentDto;
	}
	
	@PostMapping("bCommentdelete")
	@ResponseBody
	public String bCommentdelete(BCommentDto cdto, Model model)
	{
		String result = bService.bCommentdelete(cdto);
		
		System.out.println("cdto.getreno : "+cdto.getReno() );
		
		
		return result;
	}
	
	@PostMapping("bCommentmodify")
	@ResponseBody
	public Map<String, Object> bCommentmodify(BCommentDto cdto )
	{
		Map<String, Object> map = bService.bCommentmodify(cdto);
		
		System.out.println("cdto.getreno : "+cdto.getReno() );
		System.out.println("cdto.getredate : "+cdto.getRedate());
		return map;
	}
		
}
