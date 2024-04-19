package com.clayfin.request.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserProfileDto {
	
	@NotBlank
	private String base64UserProfileImg;
	
	@NotBlank
	private String companyId;
	
	@NotBlank
	private String base64UserPanCardImg;

}
