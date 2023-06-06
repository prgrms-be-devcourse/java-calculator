package com.programmers.java.service;

import com.programmers.java.repository.MapRepository;
import com.programmers.java.util.OptSplit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class CalculateService {
    private static String prior= "-+*/";

    private static MapRepository mapRepository = new MapRepository();


    public String calculator(String input) throws IOException {

        String answer="";

        OptSplit optSplit = new OptSplit();
        ArrayList<String> inputResult = optSplit.getSplit(input);

        Stack<String> digit = new Stack<>();
        Stack<String> opt = new Stack<>();

        for(int i=0;i<inputResult.size();){

            String output = inputResult.get(i);

            //연산자인 경우
            if(prior.contains(output)){
                if(opt.size()!=0){
                    int firstP = prior.indexOf(opt.peek());
                    int secondP = prior.indexOf(output);
                    if(firstP<=secondP) {
                        i++;
                        digit.add(makeResult(digit.pop(),inputResult.get(i),output));
                    }else{
                        opt.add(output);
                    }
                }else{
                    opt.add(output);
                }
                //숫자인 경우
            }else{
                digit.add(output);
            }
            i++;

        }

        while(!opt.isEmpty()){
            String operation = opt.pop();
            String second = digit.pop();
            String first = digit.pop();
            digit.add(makeResult(first,second,operation));
        }


        answer = digit.pop();
        StringBuilder sb = new StringBuilder();
        sb.append(input).append("=").append(answer);

        mapRepository.save(sb.toString());

        return answer;

    }

    static String makeResult(String one, String two, String secondP){


        int first = Integer.parseInt(one);
        int second = Integer.parseInt(two);

        String digitResult ="";

        switch (secondP){
            case "+" : digitResult= Integer.toString(first+second);
                break;
            case "-" : digitResult= Integer.toString(first-second);
                break;
            case "*" : digitResult= Integer.toString(first*second);
                break;
            default : digitResult= Integer.toString(first/second);
                break;


        }

        return digitResult;



    }

}
