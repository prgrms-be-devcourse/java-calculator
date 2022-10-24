package com.programmers.engine.parser;

import com.programmers.pages.PageList;

import java.util.Optional;

public abstract class Parser<T> {


    protected String originInput;
    protected T parsedInput;
    public abstract void parseInput(String input);
    public T getParsedInput() throws Exception{
        if(this.parsedInput == null){
            throw new Exception("잘못된 입력 입니다.");
        }else{
            return this.parsedInput;
        }
    };
    public String getOriginalInput(){
        return this.originInput;
    };

}
