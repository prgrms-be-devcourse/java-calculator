package com.programmers.java.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptSplit {

    public ArrayList<String> getSplit(String optString){

        ArrayList<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|[-+*/]");
        Matcher matcher = pattern.matcher(optString);

        while(matcher.find()){
            result.add(matcher.group());
        }

        return result;

    }
}