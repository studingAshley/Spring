package com.java.www.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BoardReplyDto {

	private int bno;
	private String repw;
	private String id;
	private String recont;
	private Timestamp date;
	private int reno;
}
