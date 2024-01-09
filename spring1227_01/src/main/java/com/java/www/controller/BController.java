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
	public String notice(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "all") String type, String word, Model model) {
		int rowPerPage = 20;
		int pages = 5;
		int maxRow = 0;
		int start = ((page-1)*rowPerPage)+1;
		int end = (start+rowPerPage)-1;
		int maxPage = (int)Math.ceil((double)maxRow/rowPerPage);
		int pageStart = (((int)Math.floor((double)page/pages))*5)+1;
		ArrayList<BoardDto> list = null;
		if(page<0)
		{
			page = 1;
		}

				

		if(word==null)
		{
			maxRow = bService.rowCounter();
			maxPage = (int)Math.ceil((double)maxRow/rowPerPage);
			if(page>maxPage)
			{
				page = maxPage;
			}
			pageStart = (((int)Math.floor((double)page/pages))*5)+1;
			
			
			list = bService.selectPage(start, end);			
		}
		else
		{
			maxRow = bService.searchRowCounter(type,word);
			maxPage = (int)Math.ceil((double)maxRow/rowPerPage);
			if(page>maxPage)
			{
				page = maxPage;
			}
			pageStart = (((int)Math.floor((double)page/pages))*5)+1;
			list = bService.searchRowPage(type,word,start,end);
		}
		
		//service연결
		//ArrayList<BoardDto> list = bService.selectAll();
		//int listLen = list.size();
		System.out.println("page : " + page);
		System.out.println("maxRow " + maxRow);
		System.out.println("start"+start);
		System.out.println("end"+end);
		System.out.println("pageStart"+((int)Math.floor((double)page/pages)));
	
		
		//model전송
		model.addAttribute("list", list);
		model.addAttribute("page",page);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("pageStart",pageStart);
		
		
		
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
