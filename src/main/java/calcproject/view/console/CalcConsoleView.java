package calcproject.view.console;

import java.util.List;
import java.util.Scanner;

import calcproject.models.CalcResultRecordModel;
import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;
import calcproject.view.Command;
import calcproject.view.Messages;

public class CalcConsoleView implements CalcInput, CalcOutput {
	private Scanner scanner;

	public CalcConsoleView() {
		this.scanner = new Scanner(System.in);
	}

	@Override
	public Command getCmd() {
		System.out.println(Messages.INPUT_GUIDE_MESSAGE.getMessage());
		System.out.print(Messages.INPUT_CHOICE_MESSAGE.getMessage());

		int choiceNum = this.scanner.nextInt();
		this.scanner.nextLine();

		System.out.println(choiceNum);
		Command command = Command.valueOf(choiceNum);
		System.out.println(command);
		return command;
	}

	@Override
	public String getExpression() {
		String expression = this.scanner.nextLine();

		return expression;
	}

	@Override
	public void showCalcResult(CalcResultRecordModel calcResultRecordModel) {
		System.out.println(calcResultRecordModel.getCalcResult() + "\n");
	}

	@Override
	public void showRecord(List<CalcResultRecordModel> calcResultRecordModelList) {
		calcResultRecordModelList.
			forEach(calcRecord -> calcRecordToFormattedStr(calcRecord));

		System.out.println();
	}

	private String calcRecordToFormattedStr(CalcResultRecordModel calcRecord) {
		String expression = calcRecord.getExpression();
		double calcResult = calcRecord.getCalcResult();
		String formattedStr = expression + " = " + calcResult;
		return formattedStr;
	}

	@Override
	public void showExitMessage() {
		System.out.println(Messages.EXIT_MESSAGE.getMessage());
	}

}
