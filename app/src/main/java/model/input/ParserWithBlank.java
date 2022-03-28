package model.input;

public class ParserWithBlank implements Parser {

	public ParserWithBlank() {
	}

	@Override
	public String[] parse(String in) {
		return in.split(" ");
	}
}
