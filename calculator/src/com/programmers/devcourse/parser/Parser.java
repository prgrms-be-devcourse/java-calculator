package com.programmers.devcourse.parser;

import com.programmers.devcourse.exception.parser.ParserException;
import java.util.List;

public interface Parser {

  List<String> parse(String target) throws ParserException;
}
