package com.techm.nine.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techm.nine.obs.entity.Account;
import com.techm.nine.obs.entity.Login;
import com.techm.nine.obs.entity.User;
import com.techm.nine.obs.repository.AccountRepository;
import com.techm.nine.obs.repository.UserRepository;
import com.techm.nine.obs.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping
	public String homePage() {

		return "homepage";
	}

	@GetMapping("/register")
	public String createRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String createUser(@ModelAttribute User user) {
		userService.createUser(user);
		System.out.println("Registration successfull!!!!!" + user.getName());
		return "redirect:/users";

	}

	@GetMapping("/login")
	public String loginUser(Model model) {
		model.addAttribute("user", new User());
		System.out.println("Login pannel!!!!!");
		return "login";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id,HttpSession session,Model model) {
		
		System.out.println(id);
		userRepository.deleteById(id);
		
		User user = (User) session.getAttribute("user");
		User newUser = userService.getUserById(user.getId());
		
		Account account = (Account) accountRepository.find(newUser.getId());
		
		System.out.println(newUser.getName() + " " + account);
		model.addAttribute("user", newUser);
		
		if(account.getAccountId() != null) {
			boolean showButton = false;
			model.addAttribute("showButton", showButton);
			session.setAttribute("account", account);
		}
		return "details";
	}


}
