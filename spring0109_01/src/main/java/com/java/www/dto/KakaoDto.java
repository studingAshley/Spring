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
public class KakaoDto {
	
	public Long id;
	public String connected_at;
	public Properties properties;
	public Kakao_account kakao_account;
	
	public class Properties{
		public String nickname;
		public String profile_image;
		public String thumbnail_image;
		
		
	}
	
	public class Kakao_account{
		public boolean profile_nickname_needs_agreement;
		public boolean profile_image_needs_agreement;
		public Profile profile;
		public boolean name_needs_agreement;
		public String name;
		public boolean email_needs_agreement;
		public String email;
		public boolean birthday_needs_agreement;
		public String birthday;
		public boolean gender_needs_agreement;
		public String gender;
		
		public class Profile{
			public String nickname;
			public String thumbnail_image_url;
			public String profile_image_url;
			public boolean is_default_image;
			
		}
	}
}
