package com.blog.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {

	int write(HttpServletRequest req);

	List<HashMap<String, Object>> lastList(int offset, int i);

	HashMap<String, Object> view(HttpServletRequest req);

	int recommend(HttpServletRequest req);

	int delete(HttpServletRequest req);

	int count();

	List<HashMap<String, Object>> bestList(int offset, int maxPost);

	int bestCount();
}
