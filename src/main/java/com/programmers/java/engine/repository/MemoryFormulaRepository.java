package com.programmers.java.engine.repository;

import java.util.ArrayList;
import java.util.List;

import com.programmers.java.engine.model.FormulaAndResult;

import lombok.Getter;

@Getter
public class MemoryFormulaRepository implements FormulaRepository {

	private final List<FormulaAndResult> history = new ArrayList<>();

	@Override
	public FormulaAndResult save(FormulaAndResult formula) {
		history.add(formula);

		return formula;
	}

	@Override
	public List<FormulaAndResult> findAll() {
		return history;
	}

	@Override
	public int size() {
		return history.size();
	}
}