package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmployeesDto;
import com.java.www.dto.MemBoardDto;
import com.java.www.mapper.EmpMapper;

@Service
public class EmployeesImpl implements EmpService {
	
	@Autowired
	EmpMapper mapper;
	
	@Override
	public ArrayList<EmployeesDto> selectAll() {
		
		ArrayList<EmployeesDto> list =  mapper.selectAll();

		return list;
	}

	@Override
	public ArrayList<EmpDeptDto> selectAll2() {
		ArrayList<EmpDeptDto> list =  mapper.selectAll2();
		return list;
	}

	@Override
	public ArrayList<MemBoardDto> selectAll3() {
		ArrayList<MemBoardDto> list =  mapper.selectAll3();
		return list;
	}

}
