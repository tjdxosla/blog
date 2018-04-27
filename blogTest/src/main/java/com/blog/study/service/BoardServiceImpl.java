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

		String message1 = "";
		String message2 = "";
		String message3 = "";
		
		HashMap<String, Object> writeMap = new HashMap<String, Object>();
		HTMLInputFilter hif = new HTMLInputFilter();
		message = hif.htmlSpecialChars(message);
		
		if(bName.length()>50){
			bName = bName.substring(0, 50);
		}
		
		if(bTitle.length()>50){
			bTitle = bTitle.substring(0, 50);
		}
		
		if(message.length()>250){
			if(message.length()>250 && message.length()>500){
				if(message.length()>500 && message.length()>=750){					
					message1 = message.substring(0, 254);			//0-254
					message2 = message.substring(255, 509);	//255-509
					message3 = message.substring(510, 764);	//510-764
				}				
			}else{
				message1 = message.substring(0, 254);
				message2 = message.substring(255, message.length());
			}
		}else{
			message1 = message.substring(0, message.length());
		}
		
		String repBname = hif.htmlSpecialChars(bName);
		String repBtitle = hif.htmlSpecialChars(bTitle);
		
		if(message2.length()!=0 && message3.length()!=0){
			writeMap.put("message2", message2);
			writeMap.put("message3", message3);
		}else if(message2.length()!=0 && message3.length()==0){
			writeMap.put("message2", message2);
		}		
		
		writeMap.put("bName", repBname);
		writeMap.put("bTitle", repBtitle);
		writeMap.put("message1", message1);
		writeMap.put("member", req.getAttribute("member"));
		
		return boardDao.write(writeMap);
	}

	@Override
	public List<HashMap<String, Object>> lastList(int offset, int i) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("offset", offset);
		listMap.put("maxPost", i);
		listMap.put("recommend", 5);
		return boardDao.lastList(listMap);
	}

	@Override
	public HashMap<String, Object> view(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		String idx = req.getParameter("idx");
		
		String reffer = req.getHeader("referer");
		String currentUrl  = req.getRequestURL()+"";		

		if(reffer.indexOf(currentUrl)==-1){
			bHitUpdate(idx);
		}
		
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

	@Override
	public int recommend(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> recommend = new HashMap<String, Object>();
		recommend.put("userId", req.getParameter("userId"));
		recommend.put("idx", req.getParameter("idx"));
		
		int result = 0;
		int chkResult = boardDao.recommendCheck(recommend);
		
		if(chkResult<=0){
			result = boardDao.recommend(recommend);
			String idx = (String) recommend.get("idx");
			boardDao.recommendUpdate(idx);
		}

		return result;
	}

	@Override
	public int delete(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		String idx = req.getParameter("idx");		
		
		return boardDao.delete(idx);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return boardDao.count();
	}

	@Override
	public List<HashMap<String, Object>> bestList(int offset, int maxPost) {
		// TODO Auto-generated method stub
		HashMap<String, Object> bestMap = new HashMap<String, Object>();
		bestMap.put("offset", offset);
		bestMap.put("maxPost", maxPost);
		bestMap.put("recommend", 5);
		return boardDao.bestList(bestMap);		
	}

	@Override
	public int bestCount() {
		// TODO Auto-generated method stub
		return boardDao.bestCount();
	}

}
