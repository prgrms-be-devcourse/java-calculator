package com.programmers.mission.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.programmers.mission.message.DefaultMessage;
import com.programmers.mission.message.ErrorMessage;

public class ConsoleView implements Input, Output {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	@Override
	public String readInput(DefaultMessage message) throws IOException {
		write(message);
		return reader.readLine();
	}

	@Override
	public void write(DefaultMessage message) throws IOException {
		writer.write(message.toString() + "\n");
		writer.flush();
	}

	@Override
	public void write(ErrorMessage message) throws IOException {
		writer.write(message.toString() + "\n\n");
		writer.flush();
	}

	@Override
	public void write(String message) throws IOException {
		writer.write(message + "\n");
		writer.flush();
	}

	@Override
	public void print(ErrorMessage message) {
		System.out.println(message.toString());
	}

}
