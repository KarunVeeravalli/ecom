package com.clayfin.serviceImpl;

import java.util.Base64;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clayfin.common.util.RepoHelper;
import com.clayfin.enums.Status;
import com.clayfin.exception.UserException;
import com.clayfin.exception.UserLoginProfileException;
import com.clayfin.model.UserProfile;
import com.clayfin.repository.UserProfileRepository;
import com.clayfin.request.dto.UserProfileDto;
import com.clayfin.response.dto.UserProfileResponseDto;
import com.clayfin.service.UserProfileService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	RepoHelper helper;
	
	@Autowired
	UserProfileRepository repository;
	
//	@Autowired
//	UserLoginProfileRepository loginProfileRepository;
	
	
	@Override
	public Status addUser(UserProfile profile, HttpServletRequest request)
			throws UserException, UserLoginProfileException {
		repository.save(profile);
		return Status.CREATED;
	}

	@Override
	public Status updateUser(UserProfileDto profile, HttpServletRequest request) throws UserException {
		UserProfile user = helper.getUserProfile(request);
		if(!user.getIsAuthorized() || !user.getCompanyId().equals(null) ) {
			throw new UserException("User Can't modify this fields");
		}
		user.setProfileImg(profile.getBase64UserProfileImg().getBytes());
		user.setCompanyId(profile.getCompanyId());
		user.setPanCard(profile.getBase64UserPanCardImg().getBytes());
		
		repository.save(user);
		
		
		return Status.UPDATED;
	}

	@Override
	public UserProfileResponseDto getUserProfile(HttpServletRequest request) throws UserException {
		UserProfile user = helper.getUserProfile(request);
		UserProfileResponseDto dto = new UserProfileResponseDto();
		dto.setCompanyId(user.getCompanyId());
		dto.setEmail(user.getEmail());
		dto.setIsAuthorized(user.getIsAuthorized());
		dto.setIsTempAdmin(user.getIsTempAdmin());
		dto.setPanCard(new String(user.getPanCard()));
		dto.setProfileImg(new String(user.getProfileImg()));
		dto.setRoles(user.getRoles());
		dto.setUsername(user.getUsername());
		
		return dto;
	}

	@Override
	public Status deleteUser(HttpServletRequest request) throws UserException {
		UserProfile user = helper.getUserProfile(request);
		repository.deleteById(user.getId());
		return Status.DELETED;
	}

//	@Override
//	public Status addManager(UserLoginProfile loginProfile, HttpServletRequest request)
//			throws UserException, UserLoginProfileException {
//		
//		
//		
//		
//		return null;
//	}

}
