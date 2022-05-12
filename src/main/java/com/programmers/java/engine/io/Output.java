package com.programmers.java.engine.io;

import java.util.List;
import java.util.Objects;

import com.programmers.java.engine.model.FormulaAndResult;

public interface Output {
	void printInfoMessage(String s);

	void printCalcResultMessage(Long result);

	void printHistory(List<FormulaAndResult> history);
}
