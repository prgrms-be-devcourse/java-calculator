package com.programmers.devcourse.parser;

import com.programmers.devcourse.parser.exception.ParserException;
import java.util.List;

public interface Parser {

  List<String> parse(String target) throws ParserException;
}
