package com.programmers.devcourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result<K, V extends Number> {

	private K key;
	private V value;

	@Override
	public String toString() {
		return this.key + " = " + this.value;
	}
}
