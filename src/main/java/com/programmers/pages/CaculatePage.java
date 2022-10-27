package com.programmers.pages;

import com.programmers.engine.caculator.Caculator;
import com.programmers.engine.model.CaculatorParseData;
import com.programmers.engine.parser.Parser;
import com.programmers.engine.repository.Repository;
import lombok.Builder;

public class CaculatePage extends Page<CaculatorParseData> {

    Repository repo;
    Caculator caculator;

    @Builder
    public CaculatePage(String content, String prompt, PageList nextPage,
                        Parser<CaculatorParseData> parser, Repository repo, Caculator caculator) {
        super(content, prompt, nextPage, parser);
        this.repo = repo;
        this.caculator = caculator;
    }

    @Override
    public void render() {
        while (true) {
            String inputString = input(getPrompt());
            getParser().parseInput(inputString);
            try {
                CaculatorParseData parsedInput = getParser().getParsedInput();
                caculator.caculate(parsedInput);
                outputData(caculator.getResult());
                repo.addData(getParser().getOriginalInput() + "=" + caculator.getResult());
                setNextPage(PageList.START);
                break;
            } catch (Exception e) {
                error(e.getMessage());
            }

        }
    }
}
