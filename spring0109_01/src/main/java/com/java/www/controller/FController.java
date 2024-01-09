package com.java.www.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.www.dto.KakaoDto;
import com.java.www.dto.TokenDto;

@Controller
public class FController {
	
	@GetMapping("/")
	public String main()
	{
		
		return "main";
	}

	@GetMapping("/login")
	public String login()
	{
		
		return "login";
	}
	
	@GetMapping("/kakao/oauth")
	@ResponseBody
	public String oauth(String code)
	{
		//1.code요청
		System.out.println("kakao code : "+ code);
		
		//2. 토큰 요청
		String token_uri = "https://kauth.kakao.com/oauth/token";
		String content_type="application/x-www-form-urlencoded;charset=utf-8";
		String grant_type = "authorization_code";
		String client_id ="4c44eb5eb98f256ba33a5c728ba55576";
		String redirect_uri ="http://localhost:8000/kakao/oauth";
		code = code;
		
		RestTemplate rt = new RestTemplate();
	
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", content_type);
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(params,headers);
		ResponseEntity<String> entity = rt.exchange(token_uri,HttpMethod.POST,tokenRequest,String.class);
		
		System.out.println("token response : "+  entity);
		System.out.println("token response.getBody() : "+  entity.getBody());
		
		ObjectMapper mapper = new ObjectMapper();
		TokenDto dto = null;
		try {
			dto =	mapper.readValue(entity.getBody(), TokenDto.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dto.getAccess_token()" + dto.getAccess_token());
		
		//3. 토큰이용하여 회원정보 받기

		String userURI = "https://kapi.kakao.com/v2/user/me";
		content_type="application/x-www-form-urlencoded;charset=utf-8";
		String authorization = "Bearer " + dto.getAccess_token();
		System.out.println("\"Bearer \" + dto.getAccess_token() : "+ authorization);
		HttpHeaders headers_user = new HttpHeaders();
		headers_user.add("Content-type", content_type);
		headers_user.add("Authorization", authorization);
		
		
		HttpEntity<MultiValueMap<String, String>> request_user = new HttpEntity<>(headers_user);
		
		System.out.println("request_user : "+ request_user.getHeaders());
		RestTemplate rt_user = new RestTemplate();
		
		ResponseEntity<String> entity_user = rt.exchange(userURI,HttpMethod.POST,request_user,String.class);
		
		ObjectMapper mapper_user = new ObjectMapper();
		KakaoDto kakaoDto = null;
		try {
			kakaoDto =	mapper_user.readValue(entity_user.getBody(), KakaoDto.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String targetUrl = "";
		if(kakaoDto != null) {
			System.out.println("카카오 로그인이 완료되었습니다.");
			targetUrl = "/";
		}
		else {
			System.out.println("카카오 로그인 에러입니다.");
			targetUrl = "login";
		}
	
		
		return "token response : "+  entity_user;
	}


}
