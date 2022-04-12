package com.programmers.mission.exception;

import com.programmers.mission.message.ErrorMessage;

public class NotSupportedMenuException extends RuntimeException {
	public NotSupportedMenuException(ErrorMessage message) {
		super(message.toString());
	}
}
