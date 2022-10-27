package com.programmers.pages;

import com.programmers.engine.parser.Parser;
import com.programmers.engine.repository.HistoryRepository;
import lombok.Builder;

public class LookupPage extends Page {
    HistoryRepository historyRepository;
    @Builder
    public LookupPage(String content, String prompt, PageList nextPage, Parser parser, HistoryRepository repo) {
        super(content, prompt, nextPage, parser);
        this.historyRepository = repo;
    }

    @Override
    public void render() {
        while(true){
            if(historyRepository.readData().size()==0){
                outputData(getContent());
            }
            outputData(historyRepository.printData());
            setNextPage(PageList.START);
            input(getPrompt());
            break;
        }
    }

}
