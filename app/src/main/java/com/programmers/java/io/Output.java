package com.programmers.java.io;

import java.util.List;

import com.programmers.java.model.History;

public interface Output {
	void response(String value);

	void responseResult(int result);

	void responseHistory(List<History> history);
}
