package com.techleads.app.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techleads.app.model.Users;
import com.techleads.app.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService userSerivce;
	@GetMapping("/registration")
	public String userRegistrationPage(@ModelAttribute("users") Users users) {
		users.setLocation("India");

		return "users_registration";

	}

	
	//This flash values will go away when page is refreshed
	/*@PostMapping("/registration")
	public String processUserRegistration(@ModelAttribute("users") Users users, Model model,

			RedirectAttributes redirectAttributes) {
		users.setLastUpdatedBy("Admin");
		users.setCreatedBy("Admin");
		users.setLastUpdatedTime(new Timestamp(new Date().getTime()));
		users.setCreatedDate(new Timestamp(new Date().getTime()));
		// return "users_registration";
		//model.addAttribute("user", users); //cannot send user object to next handler method
		// return "redirect:/success"; cannot send user object to next handler method
		redirectAttributes.addFlashAttribute("user", users);
//		Flash Attributes provide a way for one request to store attributes intended to used in another 
//		controller method during URL redirection.
		return "redirect:/success";
	}*/
	
	//Depends on the requirement configure session and put the required object in session to redirect
	@PostMapping("/registration")
	public String processUserRegistration(@ModelAttribute("users") Users users, Model model,

			HttpSession httpSession) throws Exception {
		users.setLastUpdatedBy("Admin");
		users.setCreatedBy("Admin");
		users.setLastUpdatedTime(new Timestamp(new Date().getTime()));
		users.setCreatedDate(new Timestamp(new Date().getTime()));
		users = userSerivce.saveUser(users);
		httpSession.setAttribute("userSession", users);

		return "redirect:/success";
	}

	@GetMapping("/success")
	public String userSavedPage(Model model,HttpSession httpSession) {
		
		Object sessionAttribute = httpSession.getAttribute("userSession");
		
		if(sessionAttribute==null) {
			return "redirect:/registration";
		}
		Users users = (Users)sessionAttribute;
		if (!StringUtils.isEmpty(users.getName())) {
			model.addAttribute("user", users);
			return "user_saved";
		} else {
			return "redirect:/registration";
		}

	}

}
