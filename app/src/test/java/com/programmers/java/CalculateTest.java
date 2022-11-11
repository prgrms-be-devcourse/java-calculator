package com.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.io.Console;
import com.programmers.java.model.token.TokenTypeFactory;
import com.programmers.java.repository.HistoryRepository;
import com.programmers.java.repository.MemoryHistoryRepository;
import com.programmers.java.util.FormulaValidator;
import com.programmers.java.util.PostfixParser;

class CalculateTest {
	@Test
	void calculate() {
		Console console = new Console();
		HistoryRepository repository = new MemoryHistoryRepository();
		TokenTypeFactory tokenTypeFactory = new TokenTypeFactory();
		FormulaValidator validator = new FormulaValidator(tokenTypeFactory);
		PostfixParser parser = new PostfixParser(tokenTypeFactory);
		Calculator calculator = new Calculator(console, console, repository, validator, parser);
		String[] postfixFormula1 = {"1", "2", "+", "3", "/", "5", "-", "7", "-"};
		String[] postfixFormula2 = {"12", "23", "+"};

		int result1 = calculator.calculate(postfixFormula1);
		int result2 = calculator.calculate(postfixFormula2);

		Assertions.assertEquals(result1, -11);
		Assertions.assertEquals(result2, 35);
	}
}