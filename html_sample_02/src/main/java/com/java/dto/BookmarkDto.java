package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookmarkDto {
	
	private int bookmark_id;
	private int post_id;
	private String user_id;
	private Timestamp created;
	
	
}
