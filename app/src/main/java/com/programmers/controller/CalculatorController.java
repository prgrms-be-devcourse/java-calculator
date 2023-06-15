package com.programmers.controller;

import com.programmers.service.CalculatorService;
import com.programmers.ui.InputView;
import com.programmers.ui.OutputView;
import com.programmers.util.Menu;

import java.io.IOException;
import java.util.List;

public class CalculatorController {
	
	private final InputView inputView;
	private final OutputView outputView;
	private final CalculatorService calculatorService;

	public CalculatorController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.calculatorService = new CalculatorService();
	}
	
	public void run() {
		while (true) {
			try {
				outputView.init();
				String select = inputView.select();
				Menu menu = Menu.of(select);
				if (menu == Menu.VIEW) view();
				else if (menu == Menu.CALCULATE) calculate();
				else if (menu == Menu.EXIT) {
					exit();
					break;
				}
			} catch(Exception e){
				outputView.printExceptionMessage(e.getMessage());
				if (e instanceof IOException) break;
			}
		}
		
		try {
			inputView.close();
		} catch (Exception e) {
			outputView.printExceptionMessage(e.getMessage());
		}
	}
	
	private void calculate() {
		String formula = inputView.formula();
		Integer result = calculatorService.calculate(formula);
		outputView.viewResult(result);
	}
	
	private void view() {
		List<String> record = calculatorService.view();
		outputView.viewRecord(record);
	}
	
	private void exit() {
		outputView.exit();
	}
	
}
