package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Cross_userDto;
import com.java.dto.MediaDto;
import com.java.dto.PostDto;
import com.java.mapper.Cross_userMapper;
import com.java.mapper.MediaMapper;
import com.java.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostMapper postMapper;
	@Autowired
	Cross_userMapper cUserMapper;
	@Autowired
	MediaMapper mediaMapper;
	
	@Override
	public int sendPost(PostDto postDto) {
		
		int result = postMapper.sendPost(postDto);
		
		return result;
	}

	@Override
	public Map<String, Object> getMyTimeline(String id) {
		
		Map<String, Object> map = new HashMap<>();
		ArrayList<Cross_userDto> ulist = new ArrayList<>();
		ArrayList<MediaDto> mlist = new ArrayList<>();
		
		ArrayList<PostDto> plist = postMapper.getMyTimeline(id);
		
		for(int i = 0 ; i < plist.size() ; i++)
		{
			ulist.add(cUserMapper.getUserProfile(plist.get(i).getUser_id()));
			mlist.add(mediaMapper.getMedia(plist.get(i).getPost_id()));
		}
		
		map.put("plist", plist);
		map.put("ulist", ulist);
		map.put("mlist", mlist);
		

		System.out.println("plist size : " + plist.size());
		System.out.println("ulist size : "+ ulist.size());
		System.out.println("mlist size : "+ mlist.size());
		
		
		return map;
	}

}
