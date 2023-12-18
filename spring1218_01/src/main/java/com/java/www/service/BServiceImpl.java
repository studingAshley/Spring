package com.java.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardmapper;
	@Override
	public ArrayList<BoardDto> bList() {
		
		ArrayList<BoardDto> list = boardmapper.bList();
		return list;
	}
	@Override
	public BoardDto bView(int bno) {
		
		BoardDto bdto = boardmapper.bView(bno);
		
		return bdto;
	}
	@Override
	public int bInsert(BoardDto bdto) {
		int result = boardmapper.bInsert(bdto);
		return result;
	}

}
