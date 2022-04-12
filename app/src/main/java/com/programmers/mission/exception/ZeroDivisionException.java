package com.programmers.mission.exception;

import com.programmers.mission.message.ErrorMessage;

public class ZeroDivisionException extends ArithmeticException {
	public ZeroDivisionException(ErrorMessage message) {
		super(message.toString());
	}
}
