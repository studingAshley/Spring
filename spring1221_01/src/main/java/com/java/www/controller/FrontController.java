package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmployeesDto;
import com.java.www.dto.MemBoardDto;
import com.java.www.service.EmpService;

@Controller
public class FrontController {
	
	@Autowired
	EmpService serv;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("list")
	public String list(Model model)
	{
		ArrayList<EmployeesDto> list = serv.selectAll();
		
		model.addAttribute("list",list);
		
		return "/board/list";
	}
	
	@GetMapping("list2")
	public String list2(Model model)
	{
		ArrayList<EmpDeptDto> list = serv.selectAll2();
		
		model.addAttribute("list",list);
		
		return "/board/list2";
	}
	
	
	@GetMapping("list3")
	public String list3(Model model)
	{
		ArrayList<MemBoardDto> list = serv.selectAll3();
		
		model.addAttribute("list",list);
		
		return "/board/list3";
	}


}
