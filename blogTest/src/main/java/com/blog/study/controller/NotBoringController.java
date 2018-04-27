package com.blog.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class NotBoringController {
	
	private static final Logger logger = LoggerFactory.getLogger(NotBoringController.class);
	
	@RequestMapping(value={"notBoring", "notBoring/", "notBoring/index"})
	public ModelAndView index(ModelAndView mav) {
		
		mav.setViewName("notBoring/search");
		
		return mav;
		
	}
}
