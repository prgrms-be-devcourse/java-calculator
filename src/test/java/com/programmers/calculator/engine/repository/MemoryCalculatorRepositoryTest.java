package com.programmers.calculator.engine.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryCalculatorRepositoryTest {
	CalculatorRepository repository;

	@BeforeEach
	void setUp(){
		repository = new MemoryCalculatorRepository();
	}

	@DisplayName("1. 저장 테스트")
	@Test
	public void save_test() throws Exception{
		repository.save("1 + 2 + 3","6");

		assertEquals(1,repository.size());

		repository.save("1 + 2 + 3 + 4","6");

		assertEquals(2,repository.size());

	}

	@DisplayName("2. 초기화 테스트")
	@Test
	public void clear_test() throws Exception{
		repository.save("1 + 2 + 3","6");
		repository.save("1 + 2 + 3 + 4","6");

		repository.clear();

		assertEquals(0,repository.size());
	}

	@Disabled
	@DisplayName("3. 조회 테스트")
	@Test
	public void inquiry_test() throws Exception{
		repository.save("1 + 2 + 3","6");
		repository.save("1 + 2 + 3 + 4","6");

		String expected = "1 + 2 + 3 = 6\n1 + 2 + 3 + 4 = 6\n";

		assertEquals(expected, repository.values());
	}

}
