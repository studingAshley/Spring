package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.dto.PostDto;


public interface PostService {

	int sendPost(PostDto postDto);


	Map<String, Object> getMyTimeline(String id);


	Map<String, Object> getSelected(int post_id);


	int sendModalPost(PostDto postDto);

}
