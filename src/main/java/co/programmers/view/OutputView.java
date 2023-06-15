package co.programmers.view;

import java.util.Map;

public interface OutputView {

	void printCalculationResult(Double result);

	void printMessage(String message);

	void printCalculationHistory(Map<String, Double> read);
}
