package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.PostDto;

@Mapper
public interface PostMapper {

	int sendPost(PostDto postDto);

	ArrayList<PostDto> getMyTimeline(String id);

	ArrayList<PostDto> getSelected(int post_id);

	int sendModalPost(PostDto postDto);

	PostDto getMaxStep(int post_id);

}
