package com.wellsfargo.sba2.cpk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.sba2.cpk.entity.kit;
import com.wellsfargo.sba2.cpk.exception.cpkException;
import com.wellsfargo.sba2.cpk.service.KitService;

@Controller
public class KitController {
	
	@Autowired
	private KitService kitservice;
	
	
	@GetMapping("/list")
	public ModelAndView showKitList() throws cpkException {
		return new ModelAndView("kitsListPage", "kits",kitservice.getAllKits() );		
	}
	
	@GetMapping("/newkit")
	public ModelAndView showKitFormforAdd() {
		ModelAndView mv= new ModelAndView("kitFormPage","kit", new kit());
		mv.addObject("isNew", true);
		return mv;
	}
	
	@GetMapping("/addkit")
	public ModelAndView doAddKit(@ModelAttribute("kit") @Valid kit kit,BindingResult result ) throws cpkException{
		ModelAndView mv = null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("kitFormPage","kit", kit);
			mv.addObject("isNew", true);
		}else {
			kitservice.add(kit);
			mv = new ModelAndView("index","msg", "Kit is Saved!");
		}
		
		return mv;
		
	}

	 @GetMapping("/editkit")
	 public ModelAndView showkitforEditing(@RequestParam("kitID") int kitID) throws cpkException {
		 kit kit = kitservice.getKitById(kitID);
		ModelAndView mv= new ModelAndView("kitFormPage","kit", new kit());
		mv.addObject("isNew",false);
		return mv;
	 }
	
	 @GetMapping("/savekit")
		public ModelAndView doSaveKit(@ModelAttribute("kit") @Valid kit kit,BindingResult result ) throws cpkException{
			ModelAndView mv = null;
			
			if(result.hasErrors()) {
				mv = new ModelAndView("kitFormPage","kit", kit);
				mv.addObject("isNew",false);
			}else {
				kitservice.save(kit);
				mv = new ModelAndView("index","msg", "Kit is Saved!");
			}
			
			return mv; 
	 }
	 
	 @GetMapping("/deletekit")
	 public ModelAndView doDeleteKit(@RequestParam("kitID") int kitID) throws cpkException {
		kitservice.deleteKit(kitID);
		return new ModelAndView("index","msg","kitId is deleted");
	 }
	
}
