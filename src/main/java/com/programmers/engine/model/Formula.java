package com.programmers.engine.model;

import com.programmers.engine.validate.Validator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Consumer;

public class Formula {
    private LinkedList<String> content = new LinkedList<>();
    private final StringBuilder sb = new StringBuilder();


    public void addDataToDB(DataBase db, BigDecimal result){
        for (String s : content) {
            sb.append(s);
            sb.append(" ");
        }
        // sb.append("= "); sb.append(result);
        db.addData(sb.toString(), result);
        sb.setLength(0);
    }
    public void clearContent(){content.clear();};
    public void makeFormula(String s){
        System.out.println(s);
        String[] tmp = s.split(" ");
        content.addAll(Arrays.asList(tmp));
    }

    public Boolean validate(Validator validator) {
        LinkedList<String> value = validator.validate(content);

        if (value.size() == 0) return false;

        this.content = value;
        return true;
    }


    public void indexedForEach(Consumer<String> consumer){
        for (String s : content) consumer.accept(s);
    }
}
