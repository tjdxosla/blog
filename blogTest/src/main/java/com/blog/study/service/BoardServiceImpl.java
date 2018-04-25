package com.blog.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.w3c.dom.html.HTMLInputElement;

import com.blog.study.dao.BoardDao;
import com.blog.study.utile.HTMLInputFilter;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="boardDao")
	private BoardDao boardDao;

	@Override
	public int write(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		String bName = req.getParameter("bName");
		String bTitle = req.getParameter("bTitle");
		String message = req.getParameter("message");
		
		HTMLInputFilter hif = new HTMLInputFilter();
		
		String repBname = hif.htmlSpecialChars(bName);
		String repBtitle = hif.htmlSpecialChars(bTitle);
		String repMessage = hif.htmlSpecialChars(message);
		
		HashMap<String, Object> writeMap = new HashMap<String, Object>();
		writeMap.put("bName", repBname);
		writeMap.put("bTitle", repBtitle);
		writeMap.put("message", repMessage);
		writeMap.put("member", req.getAttribute("member"));
		
		return boardDao.write(writeMap);
	}

	@Override
	public List<HashMap<String, Object>> lastList() {
		// TODO Auto-generated method stub
		return boardDao.lastList();
	}

	@Override
	public HashMap<String, Object> view(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		String idx = req.getParameter("idx");
		bHitUpdate(idx);
		HashMap<String, Object>  viewMap= cleanStr(boardDao.view(idx));		
				
		return boardDao.view(idx);
	}

	private HashMap<String, Object> cleanStr(HashMap<String, Object> viewMap) {
		// TODO Auto-generated method stub
		HTMLInputFilter hif = new HTMLInputFilter();
		
		String bName = (String) viewMap.get("bName");
		String bTitle = (String) viewMap.get("bTitle");
		String message = (String) viewMap.get("message");		

		String repbName = hif.filter(bName);
		String repbTitle = hif.filter(bTitle);
		String repMessage = hif.filter(message);
		
		HashMap<String, Object> repviewMap = new HashMap<String, Object>();
		repviewMap.put("bName", repbName);
		repviewMap.put("bTitle", repbTitle);
		repviewMap.put("message", repMessage);
		
		return repviewMap;		
	}

	private void bHitUpdate(String idx) {
		// TODO Auto-generated method stub
		
		boardDao.bHitUpdate(idx);	
	}

}