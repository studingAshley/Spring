package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.BoardDto;

public interface Bservice {

	ArrayList<BoardDto> selectAll();

	BoardDto selectOne(int bno);

}
