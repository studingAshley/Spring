package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BService {

	@Autowired
	BoardMapper mapper;
	
	/*
	 * @Override public Map<String, Object> bList(int page) {
	 * 
	 * int rowPerPage = 10; int bottomNum = 5; int cbl = mapper.countAllList(); int
	 * maxPage = (int)(Math.ceil((double)cbl/rowPerPage)); int startPage =
	 * (((page-1)/bottomNum)*bottomNum)+1; int endPage = (startPage+bottomNum)-1;
	 * 
	 * int startRow = (page-1)*10+1; int endRow = startRow + rowPerPage - 1;
	 * 
	 * 
	 * if(endPage>maxPage) { endPage = maxPage; }
	 * 
	 * ArrayList<BoardDto> list = mapper.bList(startRow,endRow); Map<String,Object >
	 * map = new HashMap<String, Object>();
	 * 
	 * System.out.println("bList StartPage : " + (page-1)/bottomNum);
	 * map.put("list", list); map.put("startPage", startPage); map.put("endPage",
	 * endPage); map.put("countAll", cbl); map.put("maxPage", maxPage);
	 * 
	 * return map; }
	 */
	@Override
	public Map<String, BoardDto> bView(int bno) {

		BoardDto bdto = mapper.bView(bno);
		BoardDto preBdto = mapper.bPreView(bno);
		BoardDto nextBdto = mapper.bNextView(bno);
		
		Map<String,BoardDto> map = new HashMap<>();
		map.put("bdto", bdto);
		map.put("preBdto", preBdto);
		map.put("nextBdto", nextBdto);
		
		return map;
	}

	@Override
	public int bWrite(BoardDto bdto) {

		int result = mapper.bWrite(bdto);
		return result;
	}

	@Override
	public BoardDto selectOne(int bno) {
		BoardDto bdto = mapper.bView(bno);
		return bdto;
	}

	@Override
	public int bDelete(int bno) {
		int result =  mapper.bDelete(bno);
		return result;
	}

	@Override
	public int doBUpdate(BoardDto bdto) {
		int result =  mapper.doBUpdate(bdto);
		return result;
	}

	@Override
	public int doBReply(BoardDto bdto) {
		int result2=0;
		int result1 = mapper.stepCounter(bdto);
		
		System.out.println("doBReply stepCounter : "+result1);

		result2 = mapper.doBReply(bdto);
		System.out.println("doBReply doBReply : "+result2);

		return result2;
	}

	@Override
	public void hitCounter(int bno) {

		mapper.hitCounter(bno);
		
	}

	@Override
	public Map<String, Object> bList(int page, String category, String searchWord) {
		ArrayList<BoardDto> list = null;
		int rowPerPage = 10;
		int bottomNum = 5;
		int cbl = mapper.countAllList(category, searchWord);
		
		int maxPage = (int)(Math.ceil((double)cbl/rowPerPage));
		int startPage = (((page-1)/bottomNum)*bottomNum)+1;
		int endPage = (startPage+bottomNum)-1;
		
		int startRow = (page-1)*10+1;
		int endRow = startRow + rowPerPage - 1;
		
		
		if(endPage>maxPage)
		{
			endPage = maxPage;
		}
		
			list = mapper.bList(category, searchWord, startRow,endRow);

		
		Map<String,Object > map = new HashMap<String, Object>();
		
		System.out.println("bList StartPage : " + (page-1)/bottomNum);
		System.out.println("bList cbl : " + cbl);
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("countAll", cbl);
		map.put("maxPage", maxPage);
		
		return map;
	}



}
