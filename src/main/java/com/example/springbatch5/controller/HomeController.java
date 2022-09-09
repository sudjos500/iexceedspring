package com.example.springbatch5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.springbatch5.models.User;

import com.example.springbatch5.services.UserService;

@Controller
public class HomeController {
	
	 @Autowired
	    UserService service;
	    
	    @RequestMapping("/")
	    public String homePage() {
	        return "index";    
	    }
	    @RequestMapping("/register")
	    public String registerpage(Model model) {
	        model.addAttribute("user", new User());
	        return "register";
	        
	        
	    }
	    @RequestMapping("/save")
	    public String savedata(User user) {
	        user.setRole("USER_ROLE");
	        user.setImageUrl("default.png");
	        user.setEnabled(true);
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPassword);
	        service.save(user);
	        return "redirect:/";
	    }
	    
	    @RequestMapping("/display")
		public String showUserss(Model model) {
			List<User> listUser = service.listUser();
			model.addAttribute("listUser",listUser);
			return "showusers";
	    }
	    
	    @RequestMapping("/edit/{id}")
		public ModelAndView editData(@PathVariable(name="id") Integer id) {
			ModelAndView mav = new ModelAndView("userupdate");
			User user =service.get(id);
			mav.addObject("user",user);
			return mav;
		}
		
		
		@RequestMapping("/delete/{id}")
		public String deleteData(@PathVariable(name="id") Integer id) {
			service.delete(id);
			return "redirect:/display";
		}
	    
	    @RequestMapping("/login")
		public String loginpage() { 	
	    	return "login";
	    }
		
		
	    
}



