package com.programmers.storage;

import com.programmers.util.Formula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StorageTest {

	Storage storage = new Storage();
	
	@BeforeEach
	void setup() throws InterruptedException {
		storage.save(new Formula("1 * 2"), 2);
		Thread.sleep(10);
		storage.save(new Formula("2 / 2"), 1);
		Thread.sleep(10);
		storage.save(new Formula("1 * 2"), 2);
	}
	
	@Test
	@DisplayName("저장을 하고 중복 저장 및 날짜 순으로 조회")
	void save() {
		// when
		List<String> record = storage.findAll();
		
		// then
		assertThat(record)
				.isNotEmpty()
				.containsExactly("1 * 2 = 2", "2 / 2 = 1", "1 * 2 = 2");
	}
	
}