package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.BoardDto;

public interface BService {

	ArrayList<BoardDto> bList();

	BoardDto bView(int bno);

	int bInsert(BoardDto bdto);

}
