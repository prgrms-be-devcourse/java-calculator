package com.programmers.mission.controller;

import java.io.IOException;

import com.programmers.mission.message.DefaultMessage;
import com.programmers.mission.message.ErrorMessage;
import com.programmers.mission.model.MenuType;
import com.programmers.mission.view.Input;
import com.programmers.mission.view.Output;

public class CalculationController {

	private final Input input;
	private final Output output;

	public CalculationController(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	public void runCalculationProgram() {
		while (true) {
			try {
				String menu = input.readInput(DefaultMessage.MENU_LIST);

				if (isOccuredInputOutputException(menu)) {
					continue;
				}

				if (MenuType.EXIT.isService(menu)) {
					break;
				}

				if (MenuType.LOOK_UP.isService(menu)) {

				} else if (MenuType.CALCULATE.isService(menu)) {
					String expression = input.readInput(DefaultMessage.NONE);
					/**
					 * 1. todo : validation check
					 * 	   1. 유효한 선택 값인지 (입력 값 : [1-2])
					 *
					 * 2. todo : 계산을 선택한 경우
					 *     1. 연산식 유효성 검증
					 *       1-1. 숫자 검증 (연산자로 잘라냈을 때, 숫자로만 이루어 져있는지 검증)
					 */
				}

				output.write(DefaultMessage.NEW_LINE);
			} catch (IOException ioException) {
				ioException.printStackTrace();
				throw new RuntimeException(ErrorMessage.INTERNAL_ERROR.toString());
			}
		}
	}

	private boolean isOccuredInputOutputException(String clientInput) {
		return clientInput.equals(ErrorMessage.INTERNAL_ERROR.toString());
	}
}
