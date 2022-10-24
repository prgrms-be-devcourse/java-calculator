package com.programmers.pages;

import java.util.Optional;

public class LookupPage extends Page{


    public LookupPage(String content, String prompt, PageList nextPage) {
        super(content, prompt, nextPage);
    }

    @Override
    public void run() {
    }

    @Override
    protected Optional<String> parse(String inputString) {
        //사용하지 않음
        return Optional.empty();
    }
}
