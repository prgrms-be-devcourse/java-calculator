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

	@Override
	public Command getCmd() {
		System.out.println(Messages.INPUT_GUIDE_MESSAGE);
		System.out.print(Messages.INPUT_CHOICE_MESSAGE);

		Scanner sc = new Scanner(System.in);
		int choiceNum = sc.nextInt();
		sc.nextLine();

		Command command = Command.valueOfCmd(choiceNum);
		return command;
	}

	@Override
	public String getExpression() {
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();

		return expression;
	}

	@Override
	public void showCalcResult(CalcRecordModel calcRecordModel) {
		System.out.println(calcRecordModel.getCalcResult() + "\n");
	}

	@Override
	public void showRecord(List<CalcRecordModel> calcRecordModelList) {
		calcRecordModelList.stream().
			forEach(s -> System.out.println(s));

		System.out.println();
	}

	@Override
	public void showExitMessage() {
		System.out.println(Messages.EXIT_MESSAGE);
	}

}
