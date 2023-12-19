package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.Bservice;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@Autowired
	Bservice serv;
	@Autowired
	HttpSession session;
	@RequestMapping("list")
	public String list(Model model)
	{
		ArrayList<BoardDto> list = serv.selectAll();
		
		model.addAttribute("list",list);
		
		return "list";
	}
	@RequestMapping("bView")
	public String bView(@RequestParam(defaultValue = "1") int bno, Model model)
	{
		System.out.println("bView bno : " + bno);
		BoardDto bdto = serv.selectOne(bno);
		
		model.addAttribute("bdto",bdto);
		
		return "bView";
	}
	
	@RequestMapping("bInsert")
	public String BInsert()
	{
	//	session.getAttribute("session_id")
		return "bInsert";
	}
	
	@RequestMapping("doBInsert")
	public String doBInsert(BoardDto boardDto, MultipartFile files, Model model )
	{
		
		return "list";
	}

}
