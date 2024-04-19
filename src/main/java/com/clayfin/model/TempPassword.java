package com.clayfin.model;

import com.clayfin.common.util.AbstractClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames =  {"email"}))
public class TempPassword extends AbstractClass {
	
	private String email;
	private String passwords;
	private Boolean isCompleted;
}
