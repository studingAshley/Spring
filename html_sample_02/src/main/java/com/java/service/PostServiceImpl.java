package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.PostDto;
import com.java.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostMapper mapper;
	
	@Override
	public int sendPost(PostDto postDto) {
		
		int result = mapper.sendPost(postDto);
		
		return result;
	}

	@Override
	public ArrayList<PostDto> getMyTimelin(String id) {
		ArrayList<PostDto> plist = mapper.getMyTimeline(id);
		return plist;
	}

}
