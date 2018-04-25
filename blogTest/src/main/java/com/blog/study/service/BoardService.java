package com.blog.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {

	int write(HttpServletRequest req);

	List<HashMap<String, Object>> lastList();

	HashMap<String, Object> view(HttpServletRequest req);

}
