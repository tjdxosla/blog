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

import com.blog.study.service.MemberService;
import com.blog.study.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping(value={"member", "member/", "member/login"})
	public ModelAndView login(ModelAndView mav, HttpServletRequest req, HttpSession session) {
		
		if(req.getParameter("id")==null || req.getParameter("id")=="" ){
			mav.setViewName("member/login");
		}else{
			//로그인 처리 로직
			HashMap<String, Object> result = memberService.login(req);
			
			if(result != null) {
				session.setAttribute("login", "1");
				session.setAttribute("id", result.get("id"));
				session.setAttribute("pass", result.get("pass"));
				session.setMaxInactiveInterval(60*60);
				mav.setViewName("redirect:/");
			}
		}
		if(session.getAttribute("login")=="1"){			
			mav.setViewName("redirect:/");			
		}
		return mav;
	}
	
	@RequestMapping(value="member/join")
	public ModelAndView join(ModelAndView mav, HttpServletRequest req, HttpSession session) {
		
		if(req.getParameter("id")==null || req.getParameter("id")=="" ){
			mav.setViewName("member/join");
		}else{
			//회원가입 처리 로직
			int result = memberService.join(req);
			
			if(result==1){
				mav.addObject("result", result);
			}else{
				mav.addObject("result", "회원가입에 문제가 발생하였습니다.");
			}
		}
		if(session.getAttribute("login")=="1"){			
			mav.setViewName("redirect:/");			
		}
		return mav;
	}
	
	@RequestMapping(value="member/idCheck")
	public ModelAndView idCheck(ModelAndView mav, HttpServletRequest req) {
		
		int result = memberService.idCheck(req);
		
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value="member/logout")
	public ModelAndView logout(ModelAndView mav, HttpSession session) {
		
		if(session.getAttribute("login")!=null) {
			session.invalidate();
		}
		
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@RequestMapping(value="member/edit")
	public ModelAndView edit(ModelAndView mav) {
		
		mav.setViewName("member/edit");
		
		return mav;
	}
	
	@RequestMapping(value="member/leave")
	public ModelAndView leave(HttpServletRequest req, HttpSession session, ModelAndView mav) {
		
		if(session.getAttribute("login")=="1"){
			session.invalidate();
		}
		
		int result = memberService.leave(req);
		
		if(result == 1){
			mav.setViewName("redirect:/");	
		}else{
			mav.addObject("msg", "회원탈퇴에 문제가 생겼습니다.");
			mav.setViewName("redirect:/edit");
		}		
		
		return mav; 
	}
}
