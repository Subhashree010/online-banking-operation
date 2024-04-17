package com.techm.nine.obs.service;

import java.util.List;

import com.techm.nine.obs.entity.Account;
import com.techm.nine.obs.entity.User;

public interface AccountService {
	
	Account addUserAccounts(Account account);
	Account getUserAccount(Long userId);
	void transferBalance(Account fromAccount,Account toAccount,double balance);
}
