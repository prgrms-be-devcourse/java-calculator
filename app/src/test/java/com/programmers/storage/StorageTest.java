package com.programmers.storage;

import com.programmers.expression.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class StorageTest {

	Storage storage = new Storage();
	
	@Test
	@DisplayName("저장을 한다")
	void save() {
		// given
		Expression expression = new Expression("1 * 2");
		int result = 3;
		
		// when
		storage.save(expression, result);
		Map<String, Integer> list = storage.findAll();
		
		// then
		assertThat(list)
				.isNotEmpty()
				.containsExactly(entry("1 * 2", 3));
	}
	
}