package calculator.parse;

import java.util.Arrays;
import java.util.List;

public class StringParse implements Parse {

	@Override
	public String parseBlank(String s) {
		return s.trim().replace(" ", "");
	}

	@Override
	public List<String> toList(String s) {
		return Arrays.asList(s.split("(?=[+/*-])|(?<=[+/*-])"));
	}
}
