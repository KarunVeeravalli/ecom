package com.clayfin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clayfin.exception.AddressException;
import com.clayfin.exception.UserException;
import com.clayfin.model.Address;
import com.clayfin.response.dto.GeneralResponse;
import com.clayfin.service.AddressService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService service;

	@PostMapping("/addAddress") 
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<GeneralResponse> addAddress(@RequestBody Address address, HttpServletRequest request)
			throws AddressException, UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("Address has been added");
			response.setData(service.addAddress(address,request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Address is not added!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAddress")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<GeneralResponse> getAddress(HttpServletRequest request) throws AddressException, UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("address found");
			response.setData(service.getAddress(request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Address not found!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateAddress/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<GeneralResponse> updateAddress(@PathVariable Long id, Address address, HttpServletRequest request)
			throws AddressException, UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("Address has been updated");
			response.setData(service.updateAddress(id,address,request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Updating Address id Failed!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getAddress/{id}")
	public ResponseEntity<GeneralResponse> getAddress(@PathVariable Long id, HttpServletRequest request)
			throws AddressException, UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("Address has been found");
			response.setData(service.getAddress(id, request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Address not found!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteAddress/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<GeneralResponse> deleteAddress(@PathVariable Long id, HttpServletRequest request)
			throws AddressException, UserException {
		var response = new GeneralResponse();
		try {
			response.setMessage("Address has been deleted");
			response.setData(service.deleteAddress(id,request));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setMessage("Address not Deleted!");
		    response.setData(e.getMessage());
		    response.setStatus(400);
		    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
