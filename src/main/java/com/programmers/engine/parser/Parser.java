package com.programmers.engine.parser;

public abstract class Parser<T> {


    protected String originInput;
    protected T parsedResultData; //Enum | Collection<String>
    public abstract void parseInput(String input);
    public T getParsedResultData() throws Exception{
        if(this.parsedResultData == null){
            throw new Exception("잘못된 입력 입니다.");
        }else{
            return this.parsedResultData;
        }
    };
    public String getOriginalInput(){
        return this.originInput;
    };

}
