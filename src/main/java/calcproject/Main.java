package calcproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import calcproject.engine.CalcExpressionTokenizer;
import calcproject.engine.Calculator;
import calcproject.models.CalcResultRecordModel;
import calcproject.repository.CalcResultRecordRepository;
import calcproject.repository.MemoryCalcResultRecordRepository;
import calcproject.service.CalcManager;
import calcproject.view.console.CalcConsoleView;

public class Main {
	public static void main(String[] args) {
		Map<Integer, CalcResultRecordModel> calcMap = new HashMap<>();
		int startIdx = 0;
		CalcResultRecordRepository calcResultRecordRepository =
			new MemoryCalcResultRecordRepository(calcMap, startIdx);
		Scanner scanner = new Scanner(System.in);
		CalcConsoleView calcConsoleView = new CalcConsoleView(scanner);
		CalcExpressionTokenizer calcExpressionTokenizer = new CalcExpressionTokenizer();
		Calculator calculator = new Calculator(calcExpressionTokenizer);

		CalcManager calcManager = new CalcManager(calcResultRecordRepository, calcConsoleView, calcConsoleView, calculator);

		calcManager.startCalcManager();
	}
}
