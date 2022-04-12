package com.programmers.mission.controller;

import java.io.IOException;
import java.util.Arrays;

import com.programmers.mission.exception.NotSupportedMenu;
import com.programmers.mission.message.DefaultMessage;
import com.programmers.mission.message.ErrorMessage;
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

				MenuType menuType = this.getMenuType(menu);

				switch (menuType) {
					case LOOK_UP -> {

					}
					case CALCULATE -> {
						String expression = input.readInput(DefaultMessage.NONE);

						if (!validation.isProperExpression(expression)) {
							output.write(ErrorMessage.CLIENT_ERROR);
							continue;
						}

					}
					case EXIT -> {
						output.write(DefaultMessage.EXIT);
						return;
					}

				}

				output.write(DefaultMessage.NEW_LINE);
			} catch (IOException ioException) {
				ioException.printStackTrace();
				output.print(ErrorMessage.INTERNAL_ERROR);
			}
		}
	}

	public MenuType getMenuType(String menu) {
		return Arrays.stream(MenuType.values())
				.filter(menuType -> menuType.isService(menu))
				.findAny()
				.orElseThrow(() -> new NotSupportedMenu(ErrorMessage.CLIENT_ERROR));

	}

}
