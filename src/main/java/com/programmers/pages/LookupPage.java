package com.programmers.pages;

import com.programmers.engine.parser.Parser;
import com.programmers.engine.repository.Repository;
import lombok.Builder;

import java.util.Optional;

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
            outputData(repo.getData());
            setNextPage(PageList.START);
            break;
        }
    }

}
