package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.IncomeDto;
import com.java.www.dto.IncomeSelectDto;

@Mapper
public interface IncomeMapper {

	//매출액 가져오기
	List<IncomeDto> incomeSelect(String cyear);

	ArrayList<IncomeSelectDto> incomeSelect();

	ArrayList<IncomeSelectDto> incomeSelectYear(String cyear);

}
