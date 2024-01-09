package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

public interface BService {

	ArrayList<BoardDto> selectAll();

	Map<String, Object> selectOne(int bno);

	//db저장된 1개의 댓글 가져오기
	BCommentDto bCommentInsert(BCommentDto cdto);

	String bCommentdelete(BCommentDto cdto);

	Map<String, Object> bCommentmodify(BCommentDto cdto);

	int rowCounter();

	ArrayList<BoardDto> selectPage(int start, int end);

	int searchRowCounter(String type, String word);

	ArrayList<BoardDto> searchRowPage(String type, String word, int start, int end);




}
