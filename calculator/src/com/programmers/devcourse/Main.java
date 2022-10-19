package com.programmers.devcourse;

import java.util.List;

import com.programmers.devcourse.calculator.Calculator;
import com.programmers.devcourse.parser.Parser;
import com.programmers.devcourse.parser.RegexParser;
import com.programmers.devcourse.processor.Processor;
import com.programmers.devcourse.processor.StringTokenProcessor;
import com.programmers.devcourse.repository.ResultRepository;
import com.programmers.devcourse.repository.StringResultRepository;

public class Main {

	static Console console = new Console();
	static ResultRepository<String, Double> repository = new StringResultRepository();
	static Parser parser = new RegexParser();
	static Processor<List<String>, Double> processor = new StringTokenProcessor();

	public static void main(String[] args) {

		Calculator calculator = new Calculator(parser, processor, console,
			console, repository);

		calculator.start();

	}

}
