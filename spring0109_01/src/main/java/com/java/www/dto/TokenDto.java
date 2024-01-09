package com.java.www.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDto {

	private String access_token;
	private String token_type;
	private String refresh_token;
	private String expires_in;
	private String scope;
	private String refresh_token_expires_in;
			
			
			/*
			 * access_token":"scdanqVisEmg1zo6VSnRys-ltQ4MyTK6Z6EKKclfAAABjOvnlRHgLMgnBn6ZSw",
			 * "token_type":"bearer","refresh_token":"H_NLeVyj3Z-gXYE8n3ZgRec6z-OXaFEFpVgKKclfAAABjOvnlQ_gLMgnBn6ZSw",
			 * "expires_in":21599,
			 * "scope":"profile_image talk_message profile_nickname",
			 * "refresh_token_expires_in":5183999
			 * */
}
