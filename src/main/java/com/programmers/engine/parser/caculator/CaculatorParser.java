package com.programmers.engine.parser.caculator;

import com.programmers.engine.model.CaculatorParseData;
import com.programmers.engine.parser.Parser;

public abstract class CaculatorParser extends Parser<CaculatorParseData> {

    public void parseInput(String input) {
        CaculatorParseData tokenizeData= tokenize(input);
        if(tokenizeData==null){
            this.parsedInput = null;
        }else{
            this.parsedInput = parseToSometingfix(tokenizeData);
        }

    }
    private CaculatorParseData tokenize(String input){
        // + * / 기준으로 나누어야 한다
        // - 는 숫자에 붙여 + 연산으로 바꾸자
        // 소수점은 퉁 쳐야 한다.
        // = 처리는 어떻게 할것인가?
        StringBuffer sb = new StringBuffer();
        this.originInput = input.replace(" ","");
        CaculatorParseData tokenizeInput = new CaculatorParseData();
        char[] originCharArray = originInput.toCharArray();
        for (int i = 0; i < originCharArray.length; i++) {
            char c = originCharArray[i];
            switch(c){
                case '*','/','+','-' ->{//가장 앞에 오는 +, -는 통과하게, 가장 마지막이 연산자로 띁나면 실패하게
                    if(i==(originCharArray.length-1)){
                        return null;
                    }
                    try{
                        tokenizeInput.add(Double.parseDouble(sb.toString()));
                        tokenizeInput.add(c);
                        sb.delete(0,sb.length());
                    }catch(NumberFormatException e){
                        if((i==0&&c=='+') || (i==0&&c=='-')){
                            sb.append(c);
                        }else{
                            return null;
                        }
                    }
                }
                case '=' ->{
                    if(i==(originCharArray.length-1)){
                        tokenizeInput.add(Double.parseDouble(sb.toString()));
                        sb.delete(0,sb.length());
                    }else{
                        return null;
                    }
                }
                case '0','1','2','3','4','5','6','7','8','9','.' ->{
                    sb.append(c);
                }
                default -> {
                    return null;
                }
            }
        }
        if(sb.length()!=0){
            tokenizeInput.add(Double.parseDouble(sb.toString()));
            sb.delete(0,sb.length());
        }
        return tokenizeInput;
    }

    protected abstract CaculatorParseData parseToSometingfix(CaculatorParseData tokenizeData);
}
