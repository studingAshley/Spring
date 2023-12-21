package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmployeesDto;
import com.java.www.dto.MemBoardDto;

public interface EmpService {

	ArrayList<EmployeesDto> selectAll();

	ArrayList<EmpDeptDto> selectAll2();

	ArrayList<MemBoardDto> selectAll3();

}
