package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.dto.BoardReplyDto;
import com.java.www.service.BService;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;

@Controller("board")
public class BoardController {
	
	@Autowired
	BService serv;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("bList")
	public String bList(@RequestParam(defaultValue = "") String category, @RequestParam(defaultValue = "")  String searchWord,@RequestParam(defaultValue = "1") int page,Model model)
	{
		Map<String, Object> map = serv.bList(page ,category, searchWord); 
		
		System.out.println("page : " + page );
		System.out.println("map startPage : " +(int)map.get("startPage") );
		System.out.println("map endPage : " +(int) map.get("endPage"));
		
		model.addAttribute("list",((ArrayList<BoardDto>) map.get("list")));
		
		model.addAttribute("startPage", (int)map.get("startPage"));
		model.addAttribute("endPage",(int) map.get("endPage"));
		model.addAttribute("countAll", (int) map.get("countAll"));
		model.addAttribute("maxPage",(int)map.get("maxPage"));
		model.addAttribute("page",page);
		model.addAttribute("category",category);
		model.addAttribute("searchWord",searchWord);
		
		
		return"board/bList";
	}
	
	@RequestMapping("bWrite")
	public String bWrite()
	{
		
		return "board/bWrite";
	}
	
	@PostMapping("doBWrite")
	public String doBWrite(BoardDto bdto,@RequestPart MultipartFile files,  Model model)
	{
		bdto.setId(session.getAttribute("session_id").toString());
		
		if(!files.isEmpty())
		{
			String oldName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String newName = time+"_"+oldName;
			String dir = "c:/upload/";
			File f = new File(dir+newName);
			
			try {
				files.transferTo(f);
				bdto.setBfile(newName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			bdto.setBfile("");
		}
		
		
		int result = serv.bWrite(bdto);
		
		model.addAttribute("result",result);
		//model.addAllAttributes("bno",bno)
		return "board/doBWrite";
	}
	
	@GetMapping("bView")
	public String bView(int bno, Model model)
	{
		System.out.println("bView bno : "+bno);
		serv.hitCounter(bno);
		Map<String, BoardDto> map = serv.bView(bno);
		
		BoardReplyDto brdto = serv.bReply(bno);
		
		model.addAttribute("map",map);
		
		return "board/bView";
	}
	
	@PostMapping("bDelete")
	public String bDelete(int bno, Model model)
	{
		int result = 0;
		BoardDto bdto = serv.selectOne(bno);
		
		if(bdto.getId().equals(session.getAttribute("session_id")))
		{
			result = serv.bDelete(bno);
		}
		
		
		model.addAttribute("result",result);
		
		return "board/doBDelete";
	}
	@PostMapping("bUpdate")
	public String bUpdate(int bno, Model model)
	{
		int result = 0;
		BoardDto bdto = serv.selectOne(bno);
		
		if(bdto.getId().equals(session.getAttribute("session_id")))
		{
			result = 1;
		}
		
		model.addAttribute("result",result);
		model.addAttribute("bdto",bdto);
		
		return "board/bUpdate";
	}
	
	
	
	@PostMapping("doBUpdate")
	public String doBUpdate(BoardDto bdto,@RequestPart MultipartFile files,  Model model)
	{
		int result = 0;
		System.out.println("doBUpdate session_id : " + session.getAttribute("session_id"));
		
		BoardDto boardDto = serv.selectOne(bdto.getBno());
		
		if(boardDto.getId().equals(session.getAttribute("session_id")))
		{
			
			if(!files.isEmpty())
			{
				String oldName = files.getOriginalFilename();
				long time = System.currentTimeMillis();
				String newName = time+"_"+oldName;
				String dir = "c:/upload/";
				File f = new File(dir+newName);
				
				try {
					files.transferTo(f);
					bdto.setBfile(newName);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}		
			
			
			result = serv.doBUpdate(bdto);
		}
		
		model.addAttribute("result",result);
		//model.addAllAttributes("bno",bno)
		return "board/doBUpdate";
	}
	
	@PostMapping("bReply")
	public String bReply(int bno, Model model)
	{
		BoardDto boardDto = serv.selectOne(bno);
		
		model.addAttribute("bdto",boardDto);
		
		return "board/bReply";
	}
	
	@PostMapping("doBReply")
	public String doBReply(BoardDto bdto,@RequestPart MultipartFile files,  Model model)
	{
		bdto.setId(session.getAttribute("session_id").toString());
		System.out.println("doBReply test start ");
		if(!files.isEmpty())
		{
			String oldName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String newName = time+"_"+oldName;
			String dir = "c:/upload/";
			File f = new File(dir+newName);
			
			try {
				files.transferTo(f);
				bdto.setBfile(newName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			bdto.setBfile("");
		}
		
		
		int result = serv.doBReply(bdto);
		System.out.println("doBReply test End ");
		
		model.addAttribute("result",result);
		//model.addAllAttributes("bno",bno)
		return "board/doBReply";
	}


}
