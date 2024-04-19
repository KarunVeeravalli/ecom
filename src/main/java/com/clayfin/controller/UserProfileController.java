package com.clayfin.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clayfin.exception.UserException;
import com.clayfin.request.dto.UserProfileDto;
import com.clayfin.response.dto.GeneralResponse;
import com.clayfin.service.UserProfileService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/userProfile")
public class UserProfileController {

	@Autowired
	UserProfileService service;

//	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
//	@PostMapping("/addUser")
//	public ResponseEntity<GeneralResponse> addUser(@RequestBody UserProfile profile, HttpServletRequest request)
//			throws UserException, UserLoginProfileException {
//		var response = new GeneralResponse();
//		response.setMessage("Use the below Generated token to login");
//		response.setData(service.addUser(profile, request));
//		return ResponseEntity.ok(response);
//	}

	@PreAuthorize("hasRole('USER')")
	@PutMapping("/updateUser")
	public ResponseEntity<GeneralResponse> updateUser(@Valid @RequestBody UserProfileDto profile, HttpServletRequest request)
			throws UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("User Profile has been Updated");
			response.setData(service.updateUser(profile, request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {		
			response.setMessage("User Profile not Updated!");
		    response.setData(e.getMessage());
			response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getUserProfile")
	public ResponseEntity<GeneralResponse> getUserProfile(HttpServletRequest request) throws UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("User Profile has been found");
			response.setData(service.getUserProfile( request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("User Profile has been not Found!");
		    response.setData(e.getMessage());
			response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/deleteUser")
	public ResponseEntity<GeneralResponse> deleteUser(HttpServletRequest request) throws UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("User has been deleted from the DB");
			response.setData(service.deleteUser(request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("User Profile has been not Deleted!");
		    response.setData(e.getMessage());
			response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
