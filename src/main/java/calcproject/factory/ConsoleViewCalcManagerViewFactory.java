package calcproject.factory;

import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;
import calcproject.view.console.CalcConsoleView;

public class ConsoleViewCalcManagerViewFactory implements CalcManagerViewFactory {

	private CalcConsoleView calcConsoleView;

	public ConsoleViewCalcManagerViewFactory() {
		this.calcConsoleView = createCalcConsoleView();
	}

	public CalcConsoleView createCalcConsoleView() {
		CalcConsoleView calcConsoleView = new CalcConsoleView();
		return calcConsoleView;
	}

	@Override
	public CalcInput createCalcInput() {
		return this.calcConsoleView;
	}

	@Override
	public CalcOutput createCalcOutput() {
		return this.calcConsoleView;
	}
}