package com.programmers.java.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TokenizerImpl implements Tokenizer {

    @Override
    public List<String> tokenizeFormula(String formula) {

        StringTokenizer st = new StringTokenizer(formula);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        while (st.hasMoreTokens()) {

            String temp = st.nextToken();
            list.add(temp);
            sb.append(temp).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return list;
    }
}
