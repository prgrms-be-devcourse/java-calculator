package com.programmers.calculator.engine;

import java.util.Objects;

import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;

public class Calculator implements Runnable {
	private Input input;
	private Output output;
	private Menu menu;
	private CalculatorRepository repository;

	public Calculator(Input input, Output output, CalculatorRepository repository) {
		Objects.requireNonNull(input);
		Objects.requireNonNull(output);
		Objects.requireNonNull(repository);

		this.input = input;
		this.output = output;
		this.repository = repository;
		menu = Menu.setRunningState();
	}

	@Override
	public void run() {
		do {
			menu = selectMenu();
			if (menu.isRunning()) {
				String formula = "";
				if (menu == Menu.CALCULATE) {
					formula = enterFomula();
				}
				String result = menu.start(repository, formula);

				output.print(result);
			}
		} while (menu.isRunning());
	}

	private Menu selectMenu() {
		while (true) {
			try {
				output.print(Menu.menuList());
				return Menu.fineMenu(input.enter());

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private String enterFomula() {
		while (true) {
			try {
				output.print("식을 입력하세요!");
				String formula = input.enter();
				if (Parser.parse(formula)) {
					return formula;
				}

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
