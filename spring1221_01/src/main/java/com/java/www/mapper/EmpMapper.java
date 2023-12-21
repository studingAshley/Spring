package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmployeesDto;
import com.java.www.dto.MemBoardDto;

@Mapper
public interface EmpMapper {

	ArrayList<EmployeesDto> selectAll();

	ArrayList<EmpDeptDto> selectAll2();

	ArrayList<MemBoardDto> selectAll3();

}
