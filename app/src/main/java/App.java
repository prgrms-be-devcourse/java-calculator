import calculation.RecordRepositoryList;
import calculation.Record;
import calculation.AluUsingStack;
import input.InputParserWithBlank;

public class App {

	public static void main(String[] args) {
		new Calculator(new InputParserWithBlank(), new AluUsingStack(), new RecordRepositoryList<Record>()).run();
	}
}
