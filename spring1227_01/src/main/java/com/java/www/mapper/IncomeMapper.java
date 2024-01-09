package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.IncomeSelectDto;

@Mapper
public interface IncomeMapper {

	ArrayList<IncomeSelectDto> incomeSelect();

	ArrayList<IncomeSelectDto> incomeSelectYear(String cyear);

}
