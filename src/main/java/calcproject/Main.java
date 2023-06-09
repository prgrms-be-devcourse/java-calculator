package calcproject;

import calcproject.engine.CalcExpressionTokenizer;
import calcproject.engine.Calculator;
import calcproject.repository.CalcRecordRepository;
import calcproject.repository.MemoryCalcRecordRepository;
import calcproject.service.CalcManager;
import calcproject.view.console.CalcConsoleView;

public class Main {
	public static void main(String[] args) {
		CalcRecordRepository calcRecordRepository = new MemoryCalcRecordRepository();
		CalcConsoleView calcConsoleView = new CalcConsoleView();
		CalcExpressionTokenizer calcExpressionTokenizer = new CalcExpressionTokenizer();
		Calculator calculator = new Calculator(calcExpressionTokenizer);

		Runnable calcManager = new CalcManager(calcRecordRepository, calcConsoleView, calcConsoleView, calculator);

		calcManager.run();
	}
}
