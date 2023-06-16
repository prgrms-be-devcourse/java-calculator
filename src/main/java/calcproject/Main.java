package calcproject;

import java.util.HashMap;
import java.util.Map;

import calcproject.engine.CalcExpressionTokenizer;
import calcproject.engine.Calculator;
import calcproject.models.CalcResultRecordModel;
import calcproject.repository.CalcResultRecordRepository;
import calcproject.repository.MemoryCalcResultRecordRepository;
import calcproject.service.CalcManager;
import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;
import calcproject.view.console.CalcConsoleView;

public class Main {
	public static void main(String[] args) {
		CalcExpressionTokenizer calcExpressionTokenizer = new CalcExpressionTokenizer();
		Calculator calculator = new Calculator(calcExpressionTokenizer);

		Map<Integer, CalcResultRecordModel> calcMap = new HashMap<>();
		CalcResultRecordRepository calcResultRecordRepository =
			new MemoryCalcResultRecordRepository(calcMap);

		CalcConsoleView calcConsoleView = new CalcConsoleView();
		CalcInput calcInput = calcConsoleView;
		CalcOutput calcOutput = calcConsoleView;

		CalcManager calcManager = new CalcManager(
			calcResultRecordRepository, calcInput, calcOutput, calculator
		);

		calcManager.startCalcManager();
	}
}
