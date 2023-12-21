package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements Bservice {
	
	@Autowired
	BoardMapper mapper;

	@Override
	public ArrayList<BoardDto> selectAll() {
		
		ArrayList<BoardDto> list = mapper.selectAll();
		
		return list;
	}

	@Override
	public BoardDto selectOne(int bno) {

		BoardDto bdto = mapper.selectOne(bno);
		return bdto;
	}

	@Override
	public int bInsert(BoardDto boardDto) {
		int result = mapper.bInsert(boardDto);
		return 0;
	}

}
