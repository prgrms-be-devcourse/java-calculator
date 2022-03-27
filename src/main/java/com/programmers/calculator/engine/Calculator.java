package com.programmers.calculator.engine;

import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.repository.MemoryCalculatorRepository;
import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;

public class Calculator implements Runnable{
	private Input input;
	private Output output;
	private Menu menu;
	private CalculatorRepository repository;

	public Calculator(Input input, Output output) {
		this.input = input;
		this.output = output;
		this.repository = new MemoryCalculatorRepository();
		menu = Menu.setRunningState();
	}

	@Override
	public void run() {
		do {
			menu = selectMenu();
			if(menu.isRunning()){
				String result = menu.start(repository);

				output.print(result);
			}
		} while (menu.isRunning());
	}

	private Menu selectMenu(){
		while(true){
			try{
				output.print(Menu.menuList());
				return Menu.fineMenu(input.enter());

			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}

	}
}
