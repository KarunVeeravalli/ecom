package com.clayfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clayfin.model.TempPassword;

public interface TempPasswordRepository extends JpaRepository<TempPassword, Long> {

	TempPassword findByEmail(String email);

}
