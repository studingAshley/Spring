package com.java.www.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class IncomeSelectDto {
	
	private String cyear;
	private String cmonth;
	private int csale;
	

}
