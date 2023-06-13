package calcproject.service;

import java.util.List;

import calcproject.engine.Calculator;
import calcproject.models.CalcResultRecordModel;
import calcproject.repository.CalcResultRecordRepository;
import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;
import calcproject.view.Command;

public class CalcManager{

	private final CalcResultRecordRepository calcResultRecordRepository;
	private final CalcInput calcInput;
	private final CalcOutput calcOutput;
	private final Calculator calculator;

	public CalcManager(CalcResultRecordRepository calcResultRecordRepository, CalcInput calcInput, CalcOutput calcOutput,
		Calculator calculator) {
		this.calcResultRecordRepository = calcResultRecordRepository;
		this.calcInput = calcInput;
		this.calcOutput = calcOutput;
		this.calculator = calculator;
	}

	public void startCalcManager() {
		Command cmd = null;

		do {
			cmd = calcInput.getCmd();
			executeCmd(cmd);
		} while (cmd != Command.EXIT);
	}

	private void executeCmd(Command cmd) {
		switch (cmd) {
			case INQUIRY:
				List<CalcResultRecordModel> calcResultRecordModels = calcResultRecordRepository.loadCalcResultRecords();
				calcOutput.showRecord(calcResultRecordModels);
				break;
			case CALCULATE:
				String expression = calcInput.getExpression();

				double calcResult = calculator.calculateExpression(expression);
				CalcResultRecordModel calcResultRecordModel = new CalcResultRecordModel(expression, calcResult);

				calcResultRecordRepository.saveCalcResultRecord(calcResultRecordModel);
				calcOutput.showCalcResult(calcResultRecordModel);
				break;
			default:
				calcOutput.showExitMessage();
				break;
		}
	}
}