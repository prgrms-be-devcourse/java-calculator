package com.programmers.pages;

import com.programmers.engine.caculator.PostfixCaculator;
import com.programmers.engine.caculator.Caculator;
import com.programmers.engine.parser.Parser;
import com.programmers.engine.repository.Repository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class CaculatePage extends Page<List<String>> {

    Repository repo;
    Caculator caculator;

    @Builder
    public CaculatePage(String content, String prompt, PageList nextPage,
                        Parser<List<String>> parser, Repository repo, Caculator caculator) {
        super(content, prompt, nextPage, parser);
        this.repo = repo;
        this.caculator = caculator;
    }

    @Override
    public void run() {
        while (true) {
            String inputString = input(getPrompt());
            getParser().parseInput(inputString);
            try {
                List<String> parsedInput = getParser().getParsedInput();
                caculator.caculate(parsedInput);
                outputData(caculator.getResult());
                repo.addData(getParser().getOriginalInput() + "=" + caculator.getResult());
                setNextPage(PageList.START);
            } catch (Exception e) {
                inputError();
            }

        }
    }
}
