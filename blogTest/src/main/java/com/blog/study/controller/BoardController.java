package com.blog.study.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blog.study.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value={"board", "board/","board/write"})
	public ModelAndView write(ModelAndView mav, HttpSession session, HttpServletRequest req) {
		
		String viewStr="redirect:/";
		
		if(session.getAttribute("login")!=null){
			if(req.getParameter("bName")!=null){
				//글쓰기 처리 로직
				req.setAttribute("member", session.getAttribute("id"));
				int result = boardService.write(req);
				mav.addObject("result", result);
				viewStr = "board/write";
			}else{
				viewStr = "board/write";
			}
		}
		
		mav.setViewName(viewStr);		
				
		return mav;
	}
	
	@RequestMapping(value="board/view")
	public ModelAndView view(ModelAndView mav, HttpServletRequest req) {
		
		HashMap<String, Object> view = boardService.view(req);
		
		mav.addObject("view", view);
		mav.setViewName("board/view");
		return mav;
	}

}
