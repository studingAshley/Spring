package com.java.www.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BCommentDto {
	
	private int reno;
	private int bno;
	private String id;
	private String repw;
	private String recont;
	private Timestamp redate;
	

}
