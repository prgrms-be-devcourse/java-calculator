package com.programmers.java.io;

import java.util.List;

import com.programmers.java.model.History;

public interface Output {
	void write(String value);

	void writeResult(int result);

	void writeAllHistory(List<History> history);
}
