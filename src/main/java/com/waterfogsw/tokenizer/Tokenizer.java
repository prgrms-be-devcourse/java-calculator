package com.waterfogsw.tokenizer;

import java.util.List;

public interface Tokenizer {
    List<String> parse(String exprStr);
}
