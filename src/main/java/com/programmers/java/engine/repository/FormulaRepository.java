package com.programmers.java.engine.repository;

import java.util.List;

import com.programmers.java.engine.model.FormulaAndResult;

public interface FormulaRepository {

	FormulaAndResult save(FormulaAndResult formula);

	List<FormulaAndResult> findAll();

	int size();
}
