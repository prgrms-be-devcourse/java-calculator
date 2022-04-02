package input;

public class InputParserWithBlank implements InputParser {

	public InputParserWithBlank() {
	}

	@Override
	public String[] parse(String in) {
		return in.split(" ");
	}
}
