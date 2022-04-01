package com.programmers.devcourse.parser;

import java.util.List;

import com.programmers.devcourse.exception.parser.ParserException;

public interface Parser {

	List<String> parse(String target) throws ParserException;
}
