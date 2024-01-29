package com.java.www.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




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
	
	@RequestMapping("analystic")
	public String analystic() {
		return "analystic";
	}
	
	@PostMapping("selectedAnalysis")
	@ResponseBody
	public JSONObject selectedAnalysis(int post_id)
	{
		JSONObject jobj = new JSONObject();

		jobj.put("viewhit0", "10");
		jobj.put("viewhit6", "25");
		jobj.put("viewhit12", "30");
		jobj.put("viewhit18", "35");

		
		return jobj;
	}

}
