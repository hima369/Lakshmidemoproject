package com.wellsfargo.sba2.cpk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	
	@GetMapping({"","/","/home"})
	public String getHome() {
		return "index";
	}
	
	@RequestMapping("/AdminHomepage")
	public String showHeader() {
		return "AdminHomepage";
	}

}
