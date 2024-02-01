package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Session;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Cross_userDto;
import com.java.dto.MediaDto;
import com.java.dto.PostDto;
import com.java.service.MediaService;
import com.java.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired HttpSession session;
	@Autowired
	PostService postService;
	@Autowired
	MediaService mediaService;
	@
	
	@RequestMapping("/")
	public String index(Model model) {
		
		String url ="/index";
		String id=null;
		
		if(session.getAttribute("session_id")==null)
		{
			url = "/login/login";
		}
		else
		{
			id= session.getAttribute("session_id").toString();
			ArrayList<PostDto> plist =  postService.getMyTimelin(id);
			
			model.addAttribute("plist", plist);
			
			ArrayList<Cross_userDto> ulist = new ArrayList<>();
			for(int i = 0 ; i < plist.size() ; i++)
			{
				ulist.add(null)
			}
			
			
			model.addAttribute("user_id",session.getAttribute("session_id").toString());
			model.addAttribute("user_profile",session.getAttribute("session_image").toString());
			model.addAttribute("user_name",session.getAttribute("session_name").toString());
		}
		
		
		return url;
	}
	
	@RequestMapping("/viewContent")
	public String view() {
		return "/view";
	}
	
	@RequestMapping("/sidebar")
	public String sidebar() {
		return "/sidebar";
	}
	
	@RequestMapping("/main")
	public String profile() {
		return "/profile/main";
	}
	
	
	@RequestMapping("/location")
	@ResponseBody
	public String location()
	{
		String param ="Location";
		
		return param;
	}
	
	@RequestMapping("analystic")
	public String analystic() {
		return "/analystic";
	}
	
	@PostMapping("/selectedAnalysis")
	@ResponseBody
	public JSONObject selectedAnalysis(int post_id)
	{
		JSONObject jobj = new JSONObject();

		jobj.put("viewhit0", "10");
		jobj.put("viewhit6", "25");
		jobj.put("viewhit12", "30");
		jobj.put("viewhit18", "35");

		
		return jobj;
	}
	
	

	@PostMapping("sendPost")
	@ResponseBody
	public String sendPost(PostDto postDto, @RequestPart List<MultipartFile> files, Model model)
	{
		MediaDto mediaDto = new MediaDto();
		
		String orgName ="";
		String newName ="";
		String MergeName="";
		String types ="";
		int totalsize=0;
		

		postDto.setUser_id(session.getAttribute("session_id").toString());
		
		System.out.println("ID : " + postDto.getUser_id());
		System.out.println("postDto.content : "+postDto.getPcontent());
		System.out.println("postDto.loc : "+postDto.getPlocation() );
		
		
		for(MultipartFile file : files)
		{
			orgName = file.getOriginalFilename();
			
			System.out.println("Media Type : " + file.getContentType());
				
			long time = System.currentTimeMillis();
			newName = time+"_"+orgName;
			
			MergeName += newName+",";
			types += file.getContentType()+",";
			totalsize += file.getSize();
			
			String upload = "C:/upload/";
			
			File f = new File(upload+newName);
			try {
				
				file.transferTo(f);
				mediaDto.setFile_name(newName);
				System.out.println("newName : " + newName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		MergeName = MergeName.substring(0, MergeName.length()-1);
		mediaDto.setFile_name(MergeName);
		
		System.out.println("MergeName : " + mediaDto.getFile_name());

		int result = postService.sendPost(postDto);
		int post_id = postDto.getPost_id();
		System.out.println("return Post ID : " + post_id );
		
		mediaDto.setPost_id(post_id);
		types = types.substring(0, types.length()-1);
		mediaDto.setFile_type(types);
		mediaDto.setFile_size(totalsize);
		if(totalsize>0)
		{
			mediaService.sendPost(mediaDto);
		}
		
		return "Test Success";
	}
	

	
	
	
	
	
	
	
}
