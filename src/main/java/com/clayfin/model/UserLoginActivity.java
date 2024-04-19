package com.clayfin.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.clayfin.common.util.AbstractClass;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_LOGIN_ACTIVITY")//,uniqueConstraints = @UniqueConstraint(columnNames = { "EMAIL" }))
public class UserLoginActivity extends AbstractClass{
	
	private String location;
	private LocalTime loginAt;
	private LocalTime logOutAt;
	private LocalTime spendHours;
	private Boolean isLoggedIn;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "USER_PROFILE_ID")
	@JsonIgnore
	private UserProfile userProfile;
	
	

}
