import model.Calculator;
import model.history.HistoryRepositoryList;
import model.history.Record;
import model.engine.AluUsingStack;
import model.input.ParserWithBlank;

public class App {

	public static void main(String[] args) {
		new Calculator(new ParserWithBlank(), new AluUsingStack(), new HistoryRepositoryList<Record>()).run();
	}
}
