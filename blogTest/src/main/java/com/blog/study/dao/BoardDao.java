package com.blog.study.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public int write(HashMap<String, Object> writeMap) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.write", writeMap);
	}

	public List<HashMap<String, Object>> lastList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.lastList");
	}

	public HashMap<String, Object> view(String idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.view", idx);
	}

	public void bHitUpdate(String idx) {
		// TODO Auto-generated method stub
		sqlSession.update("board.bHitUpdate", idx);
	}

	public int recommend(HashMap<String, Object> recommend) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.recommend", recommend);
	}

	public int recommendCheck(HashMap<String, Object> recommend) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.recommendCheck", recommend);
	}

	public void recommendUpdate(String idx) {
		// TODO Auto-generated method stub
		
		sqlSession.update("board.recommendUpdate", idx);
	}
	
	

}
