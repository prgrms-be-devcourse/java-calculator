package com.programmers.mission.controller;

import java.io.IOException;

import com.programmers.mission.exception.NotSupportedMenuException;
import com.programmers.mission.message.DefaultMessage;
import com.programmers.mission.message.ErrorMessage;
import com.programmers.mission.model.CalculationResult;
import com.programmers.mission.model.MenuType;
import com.programmers.mission.validation.InputValidation;
import com.programmers.mission.view.Input;
import com.programmers.mission.view.Output;

public class CalculationController {

	private final Input input;
	private final Output output;
	private final InputValidation validation;

	public CalculationController(Input input, Output output,
			InputValidation validation) {
		this.input = input;
		this.output = output;
		this.validation = validation;
	}

	public void runCalculationProgram() {
		while (true) {
			try {
				String menu = input.readInput(DefaultMessage.MENU_LIST);

				if (!validation.isMatchServiceType(menu)) {
					output.write(ErrorMessage.CLIENT_ERROR);
					continue;
				}

				MenuType menuType = MenuType.getMenuType(menu);

				switch (menuType) {
					case LOOK_UP -> {

					}
					case CALCULATE -> {
						String expression = input.readInput(DefaultMessage.NONE);

						if (!validation.isProperExpression(expression)) {
							output.write(ErrorMessage.CLIENT_ERROR);
							continue;
						}

						CalculationResult calculationResult = new CalculationResult(expression);
						output.write(calculationResult.toString());

					}
					case EXIT -> {
						output.write(DefaultMessage.EXIT);
						return;
					}
				}

				output.write(DefaultMessage.NEW_LINE);
			} catch (IOException | NotSupportedMenuException ioException) {
				ioException.printStackTrace();
				output.print(ErrorMessage.INTERNAL_ERROR);
			}
		}
	}

}
