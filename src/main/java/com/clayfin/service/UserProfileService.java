package com.clayfin.service;

import com.clayfin.enums.Status;
import com.clayfin.exception.UserException;
import com.clayfin.exception.UserLoginProfileException;
import com.clayfin.model.UserProfile;
import com.clayfin.request.dto.UserProfileDto;
import com.clayfin.response.dto.UserProfileResponseDto;

import jakarta.servlet.http.HttpServletRequest;

public interface UserProfileService {
	
	
	public Status addUser(UserProfile profile, HttpServletRequest request) throws UserException, UserLoginProfileException;
	
	public Status updateUser(UserProfileDto profile, HttpServletRequest request) throws UserException;
	
	public UserProfileResponseDto getUserProfile(HttpServletRequest request) throws UserException;
	
	public Status deleteUser(HttpServletRequest request) throws UserException;
	
//	public Status addManager(SignupRequest loginProfile,HttpServletRequest request) throws UserException,UserLoginProfileException;
}
