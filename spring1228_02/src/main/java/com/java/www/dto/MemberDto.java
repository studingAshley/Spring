package com.java.www.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberDto {

	public String id;
	public String pw;
	public String name;
	public String phone;
	public String gender;
	public String hobby;
	public String mdate;
}
