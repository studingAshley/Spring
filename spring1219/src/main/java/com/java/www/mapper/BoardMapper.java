package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	public int bListCount();

	ArrayList<BoardDto> selectAll();
	
	BoardDto selectOne(int bno);

	public BoardDto selectOnePrev(int bno);

	public BoardDto selectOneNext(int bno);

	public int bInsert(BoardDto bdto);

}
