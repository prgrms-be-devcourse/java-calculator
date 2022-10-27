package com.programmers.engine.parser;

import com.programmers.pages.PageList;

public class StartParser extends Parser<PageList>{

    @Override
    public void parseInput(String input){
        this.originInput = input;
         switch (input) {
            case "1" -> {
                this.parsedResultData =PageList.LOOKUP;
            }
            case "2" -> {
                this.parsedResultData = PageList.CALCULATE;
            }
            case "3" -> {
                this.parsedResultData = PageList.NONE;
            }
            default -> {
                this.parsedResultData = null;
            }
        };
    }

}
