package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> bList(int startRow, int endRow);

	BoardDto bView(int bno);

	int bWrite(BoardDto bdto);

	BoardDto bNextView(int bno);

	BoardDto bPreView(int bno);

	int bDelete(int bno);

	int doBUpdate(BoardDto bdto);

	int doBReply(BoardDto bdto);

	int stepCounter(BoardDto bdto);

	void hitCounter(int bno);

	int countAllList();

	int countAllList(String category, String searchWord);

	ArrayList<BoardDto> bList(String category, String searchWord, int startRow, int endRow);

	ArrayList<BoardDto> bListSearch(String category, String searchWord, int startRow, int endRow);

}
