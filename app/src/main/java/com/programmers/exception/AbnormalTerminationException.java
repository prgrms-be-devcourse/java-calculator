package com.programmers.exception;

import java.io.IOException;

public class AbnormalTerminationException extends IOException {
	
	public AbnormalTerminationException(String message) {
		super(message);
	}
	
}
