package com.programmers.java.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.model.History;

class HistoryRepositoryTest {

	HistoryRepository repository = new MemoryHistoryRepository();

	@Test
	void findAllHistory() {
		String formula1 = "1+2+3";
		String formula2 = "4+5+6";
		int result1 = 6;
		int result2 = 15;

		repository.save(formula1, new History(formula1, result1));
		repository.save(formula2, new History(formula1, result1));
		List<History> history = repository.findAllHistory();

		Assertions.assertEquals(history.size(), 2);
		Assertions.assertEquals(history.get(0).toString(), "1+2+3=6");
	}
}