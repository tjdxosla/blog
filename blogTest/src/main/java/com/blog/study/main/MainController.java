package com.blog.study.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blog.study.service.BoardService;
import com.blog.study.utile.Paging;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/")
	public ModelAndView mainView(ModelAndView mav, HttpServletRequest req){
		int currentPageNo = 1;
		int maxPost = 10;
		
		if(req.getParameter("pages")!=null){
			currentPageNo = Integer.parseInt(req.getParameter("pages"));			
		}
		
		Paging paging = new Paging(currentPageNo, maxPost);
		
		int offset = (paging.getCurrentPageNo()-1) * paging.getMaxPost();
		
		
		List<HashMap<String, Object>> lastMap = boardService.lastList(offset, paging.getMaxPost());
		paging.setNumberOfRecords(boardService.count());
		
		paging.makePaging();

		mav.addObject("lastMap", lastMap);
		mav.addObject("paging", paging);
		
		mav.setViewName("/main/main");
		return mav;		
	}

}
