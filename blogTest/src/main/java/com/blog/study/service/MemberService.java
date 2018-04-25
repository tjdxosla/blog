package com.blog.study.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface MemberService {

	int join(HttpServletRequest req);

	int idCheck(HttpServletRequest req);

	HashMap<String, Object> login(HttpServletRequest req);

	int leave(HttpServletRequest req);
}
