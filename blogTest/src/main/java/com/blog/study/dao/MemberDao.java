package com.blog.study.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int join(HashMap<String, Object> joinMap) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("member.join", joinMap);		
	}

	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.idCheck", id);
	}

	public HashMap<String, Object> login(HashMap<String, Object> loginMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.login", loginMap);
	}

	public int leave(String id) {
		// TODO Auto-generated method stub
		return sqlSession.delete("member.leave", id);
	}
	

}
