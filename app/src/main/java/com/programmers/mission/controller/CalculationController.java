package com.programmers.mission.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.programmers.mission.message.DefaultMessage;
import com.programmers.mission.message.ErrorMessage;
import com.programmers.mission.model.CalculationResult;
import com.programmers.mission.model.HistoryManager;
import com.programmers.mission.model.MenuType;
import com.programmers.mission.validation.InputValidation;
import com.programmers.mission.view.Input;
import com.programmers.mission.view.Output;

public class CalculationController {

	private final Input input;
	private final Output output;
	private final InputValidation validation;
	private final HistoryManager<CalculationResult> historyManager;

	public CalculationController(Input input, Output output, InputValidation validation,
			HistoryManager<CalculationResult> historyManager) {
		this.input = input;
		this.output = output;
		this.validation = validation;
		this.historyManager = historyManager;
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
						List<CalculationResult> histories = historyManager.getHistories();

						if (histories.isEmpty()) {
							output.write(DefaultMessage.NOT_EXIST_DATA);
							continue;
						}

						String result = histories.stream()
								.map(CalculationResult::toString)
								.collect(Collectors.joining("\n"));

						output.write(result);
					}
					case CALCULATE -> {
						String expression = input.readInput(DefaultMessage.NONE);

						if (!validation.isProperExpression(expression)) {
							output.write(ErrorMessage.CLIENT_ERROR);
							continue;
						}

						CalculationResult calculationResult = new CalculationResult(expression);

						historyManager.save(calculationResult);
						output.write(calculationResult.getValue());
					}
					case EXIT -> {
						output.write(DefaultMessage.EXIT);

						return;
					}
				}

				output.write(DefaultMessage.NEW_LINE);
			} catch (IOException | RuntimeException exception) {
				exception.printStackTrace();
				output.print(ErrorMessage.INTERNAL_ERROR);
			}
		}
	}

}
