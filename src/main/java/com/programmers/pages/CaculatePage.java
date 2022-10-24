package com.programmers.pages;

import java.util.Optional;

public class CaculatePage extends Page{


    public CaculatePage(String content, String prompt, PageList nextPage) {
        super(content, prompt, nextPage);
    }

    @Override
    public void run() {
    }

    @Override
    protected Optional<String> parse(String inputString) {
        return Optional.empty();
    }
}
