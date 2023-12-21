package com.java.www.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;

public interface BService {

	ArrayList<BoardDto> selectAll();

	Map<String, Object> selectOne(int i);

	BoardDto selectOnePrev(int bno);

	BoardDto selectOneNext(int bno);

	int bInsert(BoardDto bdto);

	int deleteOne(int bno);

	BoardDto SelectOne(int bno);

	int doBUpdate(BoardDto bdto);

	int bReply(BoardDto bdto);

}
