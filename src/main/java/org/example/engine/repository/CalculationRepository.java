package org.example.engine.repository;

import org.example.engine.model.CalculationResult;

import java.util.List;

public interface CalculationRepository {
	public int save(CalculationResult calculationResult);

	public List<CalculationResult> findAll();

	public void clear();

	public int size();

}
