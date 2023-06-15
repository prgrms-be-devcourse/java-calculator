package calcproject.factory;

import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;

public interface CalcManagerViewFactory {
	public CalcInput createCalcInput();
	public CalcOutput createCalcOutput();
}
