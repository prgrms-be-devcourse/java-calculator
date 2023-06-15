package com.programmers.storage;

import com.programmers.util.Formula;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Storage {
	
	private final static Map<LocalDateTime, String> map = new ConcurrentHashMap<>();
	
	public void save(Formula formula, Integer result) {
		map.put(LocalDateTime.now(), formula.toString(result));
	}
	
	public List<String> findAll() {
		if (map.size() == 0) return null;
		return map.keySet().stream()
				       .sorted()
				       .map(date -> map.get(date))
				       .collect(Collectors.toList());
		
	}
	
}
