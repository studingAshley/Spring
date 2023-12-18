package com.java.www.service;

import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;


public interface MService {

	MemberDto loginSelect(MemberDto mdto);

}
