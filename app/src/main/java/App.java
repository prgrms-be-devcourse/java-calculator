import calculation.ArithmeticLogicUnitUsingStack;
import calculation.Record;
import calculation.RecordRepositoryList;
import input.InputParserWithBlank;

public class App {

	public static void main(String[] args) {
		new Calculator(new InputParserWithBlank(), new ArithmeticLogicUnitUsingStack(),
			new RecordRepositoryList<Record>()).run();
	}
}
