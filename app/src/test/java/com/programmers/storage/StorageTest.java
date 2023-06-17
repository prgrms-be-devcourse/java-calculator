package com.programmers.storage;

import com.programmers.calculator.Formula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StorageTest {

	Storage storage = new Storage();
	
	@BeforeEach
	void setup() {
		Formula formula1 = new Formula("1 * 2");
		formula1.calcualteFormula();
		storage.save(formula1);
		
		Formula formula2 = new Formula("2 / 2");
		formula2.calcualteFormula();
		storage.save(formula2);
		
		Formula formula3 = new Formula("1 * 2");
		formula3.calcualteFormula();
		storage.save(formula3);
	}
	
	@Test
	@DisplayName("저장을 한다.")
	void save() {
		// when
		List<String> record = storage.findAll();
		
		// then
		assertThat(record)
				.isNotEmpty()
				.containsExactly("1 * 2 = 2", "2 / 2 = 1", "1 * 2 = 2");
	}
	
}