package com.programmers.storage;

import com.programmers.calculator.Formula;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Storage {
	
	private final static List<Formula> list = new ArrayList<>();
	
	public void save(Formula formula) {
		list.add(formula);
	}
	
	public List<String> findAll() {
		if (list.size() == 0) {
			return null;
		}
		return list.stream()
			       .map(Formula::toString)
			       .collect(Collectors.toList());
	}
	
}
