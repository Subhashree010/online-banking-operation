package com.techm.nine.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techm.nine.obs.entity.Account;
import com.techm.nine.obs.entity.User;
import com.techm.nine.obs.repository.AccountRepository;
import com.techm.nine.obs.repository.UserRepository;
import com.techm.nine.obs.service.AccountService;
import com.techm.nine.obs.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping
	public String homePage(Model model, HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    User newUser = userService.getUserById(user.getId());
	    System.out.println(newUser.getId());
	    Account account = accountRepository.find(newUser.getId());
	    
	    System.out.println(newUser.getName() + " " + account);
	    model.addAttribute("user", newUser);
	    
	   
	        session.setAttribute("account", account);
	    
	    
	    return "details";
	}


	@PostMapping("/login")
	public String loginUser(@RequestParam(name = "email") String userName,
			@RequestParam(name = "password") String password, Model model, HttpSession session) {
		System.out.println("login successfull!!!!!" + userName + " " + password);
		User user = userService.getUserByUserNameAndPassword(userName, password);
		System.out.println(user);
		session.setAttribute("user", user);
		// model.addAttribute("users", user);
		return "redirect:/accounts";

	}

	@GetMapping("/addAccount")
	public String createRegisterPage(Model model) {
		model.addAttribute("account", new Account());
		return "account";
	}

	@PostMapping("/addAccount")
	public String addAccount(@ModelAttribute Account account, HttpSession session) {
		System.out.println("Add account started!!!!!");
		User user = (User) session.getAttribute("user");
		// account.setUser(user);
		User newUser = userRepository.getById(user.getId());
		account.setUser(newUser);

		System.out.println("Add account ended!!!!!" + newUser.getEmail());
		return "redirect:/accounts";

	}

	@GetMapping("/showAcntDetails")
	public String showAcntDetails(Model model, HttpSession session) {
		// model.addAttribute("account", new Account());
		Account account = (Account) session.getAttribute("account");
		System.out.println("hiiiiiii" + account);
		Account newAccount = accountService.getUserAccount(account.getAccountId());
		// System.out.println(account);
		model.addAttribute("account", newAccount);
		return "acntdetails";
	}

}
