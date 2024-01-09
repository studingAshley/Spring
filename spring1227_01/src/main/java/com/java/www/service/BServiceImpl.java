package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class BServiceImpl implements BService {
	
	@Autowired
	BoardMapper boardMapper;
	@Autowired HttpSession session;
	//-------------게시글 전체
	@Override
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		
		return list;
	}

	//-----------게시글 1개
	@Override
	public Map<String, Object> selectOne(int bno) {

		BoardDto bdto = boardMapper.selectOne(bno);
		
		List<BCommentDto> list = boardMapper.BCommentSelectAll(bno);
		
		Map<String, Object> map = new HashMap<>();
		map.put("bdto", bdto);
		map.put("reply", list);
		
		return map;
	}

	@Override
	public BCommentDto bCommentInsert(BCommentDto cdto) {
		
		
		
		cdto.setId(session.getAttribute("session_id").toString());
		
		System.out.println("session.getAttribute(\"session_id\") : " + session.getAttribute("session_id").toString());
		
		boardMapper.bCommentInsert(cdto);
		
		BCommentDto bCommentDto = boardMapper.BCommentSelectOne(cdto.getReno());
		
		return bCommentDto;
	}

	@Override
	public String bCommentdelete(BCommentDto cdto) {
		String delResult = "";
		int result  = boardMapper.bCommentdelete(cdto);
		
		if(result ==1 )
		{
			delResult="del";
		}
		return delResult;
	}

	@Override
	public Map<String, Object> bCommentmodify(BCommentDto cdto) {

		Map<String,Object> map = new HashMap<>();
		String modiResult ="";
		int result = boardMapper.bCommentmodify(cdto);
		if(result==1)
		{
			modiResult="save";
		}
		
		map.put("cdto", cdto);
		map.put("result", modiResult);
		return map;
	}

	@Override
	public int rowCounter() {
		int result = boardMapper.rowCounter();
		return result;
	}

	@Override
	public ArrayList<BoardDto> selectPage(int start, int end) {

		ArrayList<BoardDto> list = boardMapper.selectPage(start,end);
		return list;
	}

	@Override
	public int searchRowCounter(String type, String word) {
		int result = 0 ;
		if(type.equals("all"))
		{
			result = boardMapper.searchRowCounterAll(word);
		}
		else if(type.equals("title"))
		{
			result = boardMapper.searchRowCounterTitle(word);
		}
		else if(type.equals("cont"))
		{
			result = boardMapper.searchRowCounterCont(word);
		}
			
		return result;
	}

	@Override
	public ArrayList<BoardDto> searchRowPage(String type, String word, int start, int end){

		ArrayList<BoardDto> list = null;
		
		if(type.equals("all"))
		{
			list = boardMapper.searchRowPageAll(word, start, end);
		}
		else if(type.equals("title"))
		{
			list = boardMapper.searchRowPageTitle(word, start, end);
		}
		else if(type.equals("cont"))
		{
			list = boardMapper.searchRowPageCont(word, start, end);
		}
		return list;
	}


	

}
