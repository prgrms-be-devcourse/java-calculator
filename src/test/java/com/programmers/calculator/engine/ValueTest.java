package com.programmers.calculator.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.programmers.calculator.engine.util.Value;

class ValueTest {

	@DisplayName("1. Equals Test")
	@Test
	public void Equals_Test() throws Exception{
		assertTrue(Value.valueOf(1).equals(Value.valueOf(1)));
		assertTrue(Value.valueOf(1).equals(Value.valueOf(1.0)));
		assertTrue(Value.valueOf(1).equals(Value.valueOf(1.0)));
		assertFalse(Value.valueOf(1).equals(Value.valueOf(2)));
		assertTrue(Value.valueOf(-11).equals(Value.valueOf(-11)));
	}

	@DisplayName("2. HashCode Test")
	@Test
	public void HashCode_Test() throws Exception{
		assertTrue(Value.valueOf(1).hashCode() == Value.valueOf(1).hashCode());
		assertTrue(Value.valueOf(1).hashCode() == Value.valueOf(1.0).hashCode());
		assertFalse(Value.valueOf(1).hashCode() == Value.valueOf(2).hashCode());
	}

	@DisplayName("3. toString Test")
	@Test
	public void to_string_test() throws Exception{
		assertEquals("5",Value.valueOf(5).toString());
		assertEquals("5.5", Value.valueOf(5.5).toString());
		assertEquals("-1", Value.valueOf(-1).toString());
	}

	@DisplayName("4. 생성 테스트")
	@Test
	public void create_test() throws Exception{
		assertEquals(Value.valueOf(55.5),Value.valueOf("55.5"));
	}

}
