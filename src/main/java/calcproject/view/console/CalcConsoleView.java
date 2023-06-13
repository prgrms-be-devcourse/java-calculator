package calcproject.view.console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import calcproject.models.CalcRecordModel;
import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;
import calcproject.view.Command;
import calcproject.view.Messages;

public class CalcConsoleView implements CalcInput, CalcOutput {
	private Scanner scanner;

	public CalcConsoleView(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public Command getCmd() {
		System.out.println(Messages.INPUT_GUIDE_MESSAGE);
		System.out.print(Messages.INPUT_CHOICE_MESSAGE);

		int choiceNum = this.scanner.nextInt();
		this.scanner.nextLine();

		Command command = Command.valueOfCmd(choiceNum);
		return command;
	}

	@Override
	public String getExpression() {
		String expression = this.scanner.nextLine();

		return expression;
	}

	@Override
	public void showCalcResult(CalcRecordModel calcRecordModel) {
		System.out.println(calcRecordModel.getCalcResult() + "\n");
	}

	@Override
	public void showRecord(List<CalcRecordModel> calcRecordModelList) {
		calcRecordModelList.
			forEach(calcRecord -> calcRecordToFormattedStr(calcRecord));

		System.out.println();
	}

	private String calcRecordToFormattedStr(CalcRecordModel calcRecord){
		String expression = calcRecord.getExpression();
		double calcResult = calcRecord.getCalcResult();
		String formattedStr = expression + " = " + calcResult;
		return formattedStr;
	}

	@Override
	public void showExitMessage() {
		System.out.println(Messages.EXIT_MESSAGE);
	}

}
