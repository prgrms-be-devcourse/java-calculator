package com.programmers.engine.parser;

import com.programmers.pages.PageList;

import java.util.Optional;

public class StartParser extends Parser<PageList>{

    @Override
    public void parseInput(String input){
        this.originInput = input;
         switch (input) {
            case "1" -> {
                this.parsedInput=PageList.LOOKUP;
            }
            case "2" -> {
                this.parsedInput = PageList.CALCULATE;
            }
            case "3" -> {
                this.parsedInput = PageList.NONE;
            }
            default -> {
                this.parsedInput = null;
            }
        };
    }

}
