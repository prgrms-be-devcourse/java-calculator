package com.programmers.mission.exception;

import com.programmers.mission.message.ErrorMessage;

public class NotSupportedOperatorException extends RuntimeException {
	public NotSupportedOperatorException(ErrorMessage message) {
		super(message.toString());
	}
}
