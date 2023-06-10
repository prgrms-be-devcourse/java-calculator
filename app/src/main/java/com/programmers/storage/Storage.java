package com.programmers.storage;

import com.programmers.expression.Expression;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
	
	private final static Map<String, Integer> map = new ConcurrentHashMap<>();
	
	public void save(Expression expression, Integer result) {
		map.put(expression.toString(), result);
	}
	
	public Map<String, Integer> findAll() {
		return map;
	}
	
}
