package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.IncomeSelectDto;
import com.java.www.mapper.IncomeMapper;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	IncomeMapper mapper;
	@Override
	public ArrayList<IncomeSelectDto> incomeSelect() {

		ArrayList<IncomeSelectDto> list = mapper.incomeSelect();
		return list;
	}
	@Override
	public ArrayList<IncomeSelectDto> incomeSelectYear(String cyear) {
		ArrayList<IncomeSelectDto> list = mapper.incomeSelectYear(cyear);
		return list;
	}

}
