package org.example;

import org.example.engine.Calculator;
import org.example.engine.repository.CalculationRepository;
import org.example.engine.repository.OrderedInmemoryCalculationRepository;

public class App {
	public static void main(String[] args) {

		Console console = new Console();
		CalculationRepository calculationRepository = new OrderedInmemoryCalculationRepository();
		new Calculator(console, calculationRepository).run();

	}

}



