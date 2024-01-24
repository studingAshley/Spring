package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class FController {
	
	@RequestMapping("/")	
	public String index()
	{
		
		return "index";
	}

	@GetMapping("viewContent")
	public String viewContent() {
		
		return "view";
	}
	
	@RequestMapping("location")
	@ResponseBody
	public String location()
	{
		String param ="Location";
		
		return param;
	}

}
