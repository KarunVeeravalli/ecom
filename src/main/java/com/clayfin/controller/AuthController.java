package com.clayfin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clayfin.exception.UserLoginProfileException;
import com.clayfin.request.dto.LoginRequest;
import com.clayfin.request.dto.OtpDto;
import com.clayfin.request.dto.PasswordDto;
import com.clayfin.request.dto.SignupRequest;
import com.clayfin.response.dto.GeneralResponse;
import com.clayfin.service.UserLoginProfileService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {


  
  @Autowired
  UserLoginProfileService service;


  @PostMapping("/signin")
  public ResponseEntity<GeneralResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws UserLoginProfileException {
	  
	  var response = new GeneralResponse();
	  try {
		  response.setMessage("Use the below Generated token to login");
		  response.setData(service.login(loginRequest));
		  return ResponseEntity.ok(response);
	} catch (Exception e) {
		response.setMessage("Login has been Failed!");
	    response.setData(e.getMessage());
	    response.setStatus(400);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
  }

  @PostMapping("/signup")
  public ResponseEntity<GeneralResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws UserLoginProfileException {
    var response = new GeneralResponse();
    try {
    	response.setMessage("User registered successfully!");
        response.setData(service.register(signUpRequest));
        return ResponseEntity.ok(response);
	} catch (Exception e) {
		response.setMessage("Registration has been Failed!");
	    response.setData(e.getMessage());
	    response.setStatus(400);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
  }
  
  @PutMapping("/changePassword")
  public ResponseEntity<GeneralResponse> changePassword(@Valid @RequestBody PasswordDto dto) throws UserLoginProfileException{
	  var response = new GeneralResponse();
	  try {
		  	response.setMessage("Password has been changed successfully!");
		    response.setData(service.changePassword(dto));
		    return ResponseEntity.ok(response);
	} catch (Exception e) {
		    response.setMessage("Password has not been changed!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
  }
  
  @PostMapping("/verifyOtpForPasswordUpdate")
  public ResponseEntity<GeneralResponse> verifyOtpForPasswordUpdate(@Valid @RequestBody OtpDto dto) throws UserLoginProfileException{
	  var response = new GeneralResponse();
	    try {
	    	response.setMessage("User registered successfully!");
		    response.setData(service.verifyOtpForPasswordUpdate(dto));
		    return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Verifying Otp is Failed!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
  }
   
  @PostMapping("/verifyOtp")
  public ResponseEntity<GeneralResponse> verifyOtp(@Valid @RequestBody OtpDto dto) throws UserLoginProfileException{
	  var response = new GeneralResponse();
	    try {
	    	response.setMessage("User registered successfully!");
		    response.setData(service.verifyOtpForRegister(dto));
		    return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Verifying Otp is Failed!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
  }
  
  @GetMapping("/findAll")
  public ResponseEntity<GeneralResponse> findAllUsers() throws UserLoginProfileException{
	  	var response = new GeneralResponse();
		try {
		    response.setMessage("Users Found:");
		    response.setData(service.getAllUserNames());
		    return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Finding users is Failed!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
  }
}
