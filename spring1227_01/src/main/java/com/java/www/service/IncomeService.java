package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.IncomeSelectDto;

public interface IncomeService {

	ArrayList<IncomeSelectDto> incomeSelect();


	ArrayList<IncomeSelectDto> incomeSelectYear(String cyear);

}
