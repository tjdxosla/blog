package com.blog.study.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blog.study.service.BoardService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/")
	public ModelAndView mainView(ModelAndView mav){
		
		List<HashMap<String, Object>> lastMap = boardService.lastList();		

		mav.addObject("lastMap", lastMap);
		
		mav.setViewName("/main/main");
		return mav;
		
	}

}
