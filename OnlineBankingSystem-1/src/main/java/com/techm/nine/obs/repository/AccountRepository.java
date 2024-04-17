package com.techm.nine.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techm.nine.obs.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	//@Query("SELECT u FROM User u WHERE u.user_id = :id AND u.password = :password")
	/*
	 * @Query("SELECT u.account_id,u.account_no,u.account_type,u.balance,u.user_id FROM Account u join user on u.user_id = :id"
	 * ) Account find(@Param(value="user_id") Long id);
	 */
	
	@Query("SELECT a FROM Account a WHERE a.user.id = :id")
    Account find(@Param("id") Long id);
}
