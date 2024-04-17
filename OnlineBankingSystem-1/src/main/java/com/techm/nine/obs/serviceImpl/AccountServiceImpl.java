package com.techm.nine.obs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.nine.obs.entity.Account;
import com.techm.nine.obs.entity.User;
import com.techm.nine.obs.repository.AccountRepository;
import com.techm.nine.obs.repository.UserRepository;
import com.techm.nine.obs.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void transferBalance(Account fromAccount, Account toAccount, double balance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account addUserAccounts(Account account) {

		accountRepository.save(account);
		return null;
	}

	@Override
	public Account getUserAccount(Long userId) {
		
		Account account = accountRepository.findById(userId).get();
		return account;
	}

}
