package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.PostDto;


public interface PostService {

	int sendPost(PostDto postDto);

	ArrayList<PostDto> getMyTimelin(String id);

}
