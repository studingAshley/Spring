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


	void deleteOne(int post_id);


	PostDto getSeletedHit(int post_id);


	int repeatOn(int post_id);


	int repeatOff(int post_id);


	int favoriteOn(int post_id);


	int favoriteOff(int post_id);

}
