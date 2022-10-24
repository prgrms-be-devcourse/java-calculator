package calculator.io;

import java.util.List;

public interface Output {

	void requestInput();

	void printAnswer(String result);

	void printFormulas(List<String> list);

	void printExit();

	void printWrongOrder();

	void printDivideZero();

	void printNoData();

	void printWrongFormula();
}
