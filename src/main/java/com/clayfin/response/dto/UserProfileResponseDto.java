package com.clayfin.response.dto;

import java.util.HashSet;
import java.util.Set;

import com.clayfin.model.Role;

import lombok.Data;

@Data
public class UserProfileResponseDto {
	
	private String username;

	private String email;
	  
//	  private List<Address> address;
	  
	  
//	  private List<Orders> orders;
	  

//	  private List<Transaction> transactions;
	  
//	 private List<UserLoginActivity> userLoginActivities;
	  
	  private Boolean isAuthorized ;
	  
	  private Boolean isTempAdmin;
	  
	  private Set<Role> roles = new HashSet<>();
	  
	  private String profileImg;
	  
	  private String companyId;
	  
	  private String panCard;
}
