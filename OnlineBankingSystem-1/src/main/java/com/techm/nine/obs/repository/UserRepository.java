package com.techm.nine.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techm.nine.obs.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
	User findByUserNameAndPassword(@Param("email") String username, @Param("password") String password);
}
