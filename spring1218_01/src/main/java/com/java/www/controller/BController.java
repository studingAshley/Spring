package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired
	BService bService;
	@Autowired
	HttpSession session;
	
	@RequestMapping("bList")
	public String bList(Model model)
	{
		ArrayList<BoardDto> list = 	bService.bList();
		
		model.addAttribute("list",list);
		return "board/bList";
	}
	
	@RequestMapping("bView")
	public String bView(@RequestParam(defaultValue = "1") int bno, Model model)
	{
		BoardDto bdto = bService.bView(bno);

		model.addAttribute("bdto", bdto);
		return "board/bView";
	}
	
	@RequestMapping("bInsert")
	public String bInsert()
	{
		/*
		 * UUID uuid = UUID.randomUUID(); String fileName = "a.jpg";
		 * System.out.println("UUID : "+uuid); System.out.println(uuid+"_"+fileName);
		 * 
		 * long time = System.currentTimeMillis();
		 * System.out.println(time+"_"+fileName);
		 */
		
		return "board/bInsert";
	}
	
	@RequestMapping("doBInsert")
	public String doBInsert(BoardDto bdto,@RequestPart MultipartFile file ,Model model) //input type이 file인 것 제외하고 bdto로 입력
	{
		bdto.setId(session.getAttribute("session_id").toString());
		System.out.println("doBInsert");
		int result = 0 ;
		if(!file.isEmpty()) // 파일이 첨부되었을 때
		{
			String oriFileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String newFileName = uuid+"_"+oriFileName;
			
			String fileUpload = "C:/upload/";
			File f = new File(fileUpload+newFileName);
			try {
				file.transferTo(f);
				bdto.setBfile(newFileName);
				result = bService.bInsert(bdto);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			result = bService.bInsert(bdto);
		}
		 
		model.addAttribute("result",result);
		
		
		return "board/doBInsert";
	}

}
