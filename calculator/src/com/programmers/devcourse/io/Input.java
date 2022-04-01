package com.programmers.devcourse.io;

import java.io.IOException;

public interface Input extends AutoCloseable {

	int getMenuSelection() throws IOException;

	String getExpression() throws IOException;

	void close() throws IOException;
}


