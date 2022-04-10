package com.programmers.mission.view;

import java.io.IOException;

import com.programmers.mission.message.DefaultMessage;

public interface Input {

	String readInput(DefaultMessage message) throws IOException;
}
