package com.blog.study.service;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.blog.study.dao.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDao")
	private MemberDao memberDao;
	@Override
	public int join(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> joinMap = new HashMap<String, Object>();
		joinMap.put("id", req.getParameter("id"));
		joinMap.put("pass", req.getParameter("pass"));
		joinMap.put("passCheck", req.getParameter("passCheck"));
		joinMap.put("phone", req.getParameter("phone"));
		
		return memberDao.join(joinMap);		
	}
	@Override
	public int idCheck(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		return memberDao.idCheck(id);
	}
	@Override
	public HashMap<String, Object> login(HttpServletRequest req) {
		// TODO Auto-generated method stub
		HashMap<String, Object> loginMap = new HashMap<String, Object>();
		loginMap.put("id", req.getParameter("id"));
		loginMap.put("pass", req.getParameter("pass"));
		return memberDao.login(loginMap);
	}
	@Override
	public int leave(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		return memberDao.leave(id);
	}
}
