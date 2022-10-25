package com.programmers.java.io;

import java.util.List;

import com.programmers.java.model.History;

public interface Output {
	void printMenu(String menu);

	void printHistory(List<History> history);

	void printFormulaResult(int result);

	void printExit(String exitMessage);

	void printErrorMessage(String errorMessage);
}
