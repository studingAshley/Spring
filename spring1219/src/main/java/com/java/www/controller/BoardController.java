package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class BoardController {

	@Autowired
	BService serv;
	@Autowired
	HttpSession session;
	
	@GetMapping("bList")
	public String bList(Model model)
	{
		ArrayList<BoardDto> list = serv.selectAll();
		
		model.addAttribute("list",list);
		
		return "/board/bList";
	}
	@GetMapping("bList2")
	public String bList2(Model model)
	{
		ArrayList<BoardDto> list = serv.selectAll();
		
		model.addAttribute("list",list);
		
		return "/board/bList";
	}
	
	
	@RequestMapping("bView")
	public String bView(BoardDto bdto, Model model)
	{
		Map<String, Object> boardDto = serv.selectOne(bdto.getBno());
		
		model.addAttribute("map",boardDto );
		
		return "/board/bView";
	}
	
	@RequestMapping("bView2")
	public String bView2(BoardDto bdto, Model model)
	{
		Map<String, Object> boardDto = serv.selectOne(bdto.getBno());
		
		model.addAttribute("map",boardDto );
		
		return "/board/bView";
	}
	
	@GetMapping("bInsert")
	public String bInsert() {
		return "/board/bInsert";
	}
	
	@PostMapping("bInsert")
	public String bInsert(BoardDto bdto,@RequestPart MultipartFile files, Model model) {
		
		if(!files.isEmpty())
		{
			String orgName = files.getOriginalFilename();
			
			long time = System.currentTimeMillis();
			String newName = time+"_"+orgName;
	
			String upload = "C:/upload/";
			
			File f = new File(upload+newName);
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
		
		int result = serv.bInsert(bdto);
		
		model.addAttribute("result",result);
		
		return "/board/doBInsert";
	}
	
	/* =================================================================================== */
	
	@GetMapping("bInsert2")
	public String bInsert2() {
		return "/board/bInsert2";
	}
	
	@PostMapping("bInsert2")
	public String bInsert2(BoardDto bdto,@RequestPart List<MultipartFile> files, Model model) {
		String orgName ="";
		String newName ="";
		String MergeName="";
		for(MultipartFile file : files)
		{
			orgName = file.getOriginalFilename();
			
			long time = System.currentTimeMillis();
			newName = time+"_"+orgName;
			MergeName += newName+",";
	
			String upload = "C:/upload/";
			
			File f = new File(upload+newName);
			try {
				file.transferTo(f);
				bdto.setBfile(newName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		MergeName = MergeName.substring(0, MergeName.length()-1);
		bdto.setBfile(MergeName);
		
		int result = serv.bInsert(bdto);
		
		model.addAttribute("result",result);
		
		System.out.println("MergeName : " +MergeName);
		
		return "/board/doBInsert";
	}
	
}
