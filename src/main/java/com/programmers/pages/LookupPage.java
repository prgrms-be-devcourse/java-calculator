package com.programmers.pages;

import com.programmers.engine.parser.Parser;
import com.programmers.engine.repository.Repository;
import lombok.Builder;

import java.util.Collection;

public class LookupPage extends Page {
    Repository repo;
    @Builder
    public LookupPage(String content, String prompt, PageList nextPage, Parser parser,Repository repo) {
        super(content, prompt, nextPage, parser);
        this.repo = repo;
    }

    @Override
    public void run() {
        while(true){
            if(repo.readData().size()==0){
                outputData(getContent());
            }
            outputData(repo.printData());
            setNextPage(PageList.START);
            input(getPrompt());
            break;
        }
    }

}
