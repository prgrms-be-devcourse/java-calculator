package com.programmers.mission.exception;

import com.programmers.mission.message.ErrorMessage;

public class NotSupportedMenu extends RuntimeException {
	public NotSupportedMenu(ErrorMessage message) {
		super(message.toString());
	}
}
