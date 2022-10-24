package com.programmers.pages;


import com.programmers.engine.parser.Parser;
import lombok.Builder;

import java.util.Optional;

public class StartPage extends Page<PageList> {


    @Builder
    public StartPage(String content, String prompt, PageList nextPage, Parser<PageList> parser) {
        super(content, prompt, nextPage, parser);
    }

    @Override
    public void run() {
        while (true) {
            String inputString;
            outputData(getContent());
            inputString = input(getPrompt());
            getParser().parseInput(inputString);
            try{
                PageList parsedInput = getParser().getParsedInput();
                setNextPage(parsedInput);
            }catch (Exception e){
                inputError();
                continue;
            }
        }

    }

}
