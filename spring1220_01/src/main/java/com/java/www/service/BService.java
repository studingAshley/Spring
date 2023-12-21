package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {


	Map<String,BoardDto> bView(int bno);

	int bWrite(BoardDto bdto);

	BoardDto selectOne(int bno);

	int bDelete(int bno);

	int doBUpdate(BoardDto bdto);

	int doBReply(BoardDto bdto);

	void hitCounter(int bno);

	Map<String, Object> bList(int page, String category, String searchWord);


}
