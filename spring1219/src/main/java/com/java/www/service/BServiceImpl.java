package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public ArrayList<BoardDto> selectAll() {

		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public Map<String,Object> selectOne(int bno) {

		BoardDto bdto = boardMapper.selectOne(bno);
		BoardDto bdtoPrev = boardMapper.selectOnePrev(bno);
		BoardDto bdtoNext = boardMapper.selectOneNext(bno);
		
		boardMapper.bHitUp(bno);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bdto", bdto);
		map.put("bdtoPrev", bdtoPrev);
		map.put("bdtoNext", bdtoNext);
		
		return map;
	}

	@Override
	public BoardDto selectOnePrev(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDto selectOneNext(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int bInsert(BoardDto bdto) {
		int result = boardMapper.bInsert(bdto);
		return result;
	}

	@Override
	public int deleteOne(int bno) {
		int result =  boardMapper.deleteOne(bno);
		return result;
	}

	@Override
	public BoardDto SelectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

	@Override
	public int doBUpdate(BoardDto bdto) {
		int result = boardMapper.doBUpdate(bdto);
		return result	;
	}

	@Override
	public int bReply(BoardDto bdto) {
		// 부모보다 큰 bstep을 가진 게시물의 bstep + 1 / 답변달기 글의 bstep은 부모의 bstep + 1 /bgroup은 부모와 같음 /indent 부모의 indent + 1
		
		boardMapper.bstepUp(bdto);

		int result = boardMapper.doBReply(bdto);
		return result;
	}






}
