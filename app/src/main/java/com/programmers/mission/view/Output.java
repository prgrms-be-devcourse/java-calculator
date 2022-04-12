package com.programmers.mission.view;

import java.io.IOException;

import com.programmers.mission.message.DefaultMessage;
import com.programmers.mission.message.ErrorMessage;

public interface Output {
	void write(DefaultMessage message) throws IOException;

	void write(ErrorMessage message) throws IOException;

	void write(String message) throws IOException;

	void print(ErrorMessage message);
}
