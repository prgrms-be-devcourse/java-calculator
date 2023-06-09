package calcproject.service;

import java.util.List;

import calcproject.engine.Calculator;
import calcproject.models.CalcRecordModel;
import calcproject.repository.CalcRecordRepository;
import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;
import calcproject.view.Command;

public class CalcManager implements Runnable {

	private final CalcRecordRepository calcRecordRepository;
	private final CalcInput calcInput;
	private final CalcOutput calcOutput;
	private final Calculator calculator;

	public CalcManager(CalcRecordRepository calcRecordRepository, CalcInput calcInput, CalcOutput calcOutput,
		Calculator calculator) {
		this.calcRecordRepository = calcRecordRepository;
		this.calcInput = calcInput;
		this.calcOutput = calcOutput;
		this.calculator = calculator;
	}

	public void run() {
		Command cmd = null;

		do {
			cmd = calcInput.getCmd();
			executeCmd(cmd);
		} while (cmd != Command.EXIT);
	}

	private void executeCmd(Command cmd) {
		switch (cmd) {
			case INQUIRY:
				List<CalcRecordModel> calcRecordModels = calcRecordRepository.loadCalcRecords();
				calcOutput.showRecord(calcRecordModels);
				break;
			case CALCULATE:
				String expression = calcInput.getExpression();

				double calcResult = calculator.calculateExpression(expression);
				CalcRecordModel calcRecordModel = new CalcRecordModel(expression, calcResult);

				calcRecordRepository.saveCalcRecord(calcRecordModel);
				calcOutput.showCalcResult(calcRecordModel);
				break;
			default:
				calcOutput.showExitMessage();
				break;
		}
	}
}