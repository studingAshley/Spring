package com.java.www.controller;

import java.awt.desktop.SystemSleepEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;

@Controller
public class DataController {
	
	@ResponseBody
	@RequestMapping("boardBno/{bno}/{bhit}")
	public String boardBno(@PathVariable int bno, @PathVariable int bhit)
	{
		String txt = "boardBno 글번호 : " + bno;
		txt += "\n boardBno 조회수 : " + bhit;
		
		return txt;
	}
	
	
	@ResponseBody
	@RequestMapping("aaa")
	public String aaa()
	{
		return "aaa";
	}
	
	@ResponseBody
	@RequestMapping("idCheck")
	public Map<String, Object> idCheck( String id )
	{
		Map<String, Object> map = new HashMap<>();
		if(id.equals("aaa"))
		{
			map.put("result", "Fail");
		}
		else
		{
			map.put("result", "Success");
		}
		
		//JSONArray jarr = new JSONArray();
		//JSONObject jobj = new JSONObject();
		
		map.put("name", "Hong");
		map.put("phone", "010-1111-1111");
		map.put("bno", 1);
		map.put("mdto", new MemberDto("bbb", "1111", "YU", "010", "Female","game,golf", new Timestamp(System.currentTimeMillis())));
		
		ArrayList<MemberDto> list = new ArrayList<>();
		
		list.add(new MemberDto("ccc", "1111", "Lee", "010223123", "Female","game,golf", new Timestamp(System.currentTimeMillis())));
		list.add(new MemberDto("ddd", "1111", "Kang", "010123123", "Male","game,golf", new Timestamp(System.currentTimeMillis())));
		
		map.put("list",list);
		return map;
	}

}
