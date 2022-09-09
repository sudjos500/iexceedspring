package com.example.springbatch5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbatch5.models.Contact;
import com.example.springbatch5.services.ContactService;

@Controller
@RequestMapping("/user")
public class ContactController {
	@Autowired
	ContactService services;
	
    @RequestMapping("/contactmanager")
    public String contactpage(Model model) {
        model.addAttribute("contact", new Contact());
        return "Contact/contactmanager";
    }
	
	
	@RequestMapping("/saves")
    public String savesdata(Contact contact) {
        contact.setSecondName("SECOND NAME");
        contact.setImage("default.png");
        services.save(contact);
        return "redirect:/";
	}
	@RequestMapping("/displays")
	public String showcontacts(Model model) {
		List<Contact> listContact = services.listContact();
		model.addAttribute("listContact",listContact);
		return "Contact/showcontacts";
    }
	
	@RequestMapping("/editC/{cId}")
	public ModelAndView editcontactData(@PathVariable(name="cId") Integer cId) {
		ModelAndView con = new ModelAndView("Contact/contactupdate");
		Contact contact =services.get(cId);
		con.addObject("Contact",contact);
		return con;
	}
	
	
	@RequestMapping("/deleteC/{id}")
	public String deletecontactData(@PathVariable(name="id") Integer id) {
		services.delete(id);
		return "redirect:/user/displays";
	}
}
