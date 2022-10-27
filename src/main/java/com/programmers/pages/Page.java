package com.programmers.pages;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.parser.Parser;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Optional;
import java.util.Scanner;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public abstract class Page <T> implements Input, Output{
    private final Scanner scanner = new Scanner(System.in);
    private String content;
    private String prompt;
    private PageList nextPage;

    private Parser<T> parser;


    protected void setNextPage(PageList nextPage) {
        this.nextPage = nextPage;
    }
    @Override
    public String input(String prompt) {
        this.prompt = prompt;
        if(this.prompt.isEmpty()) {
            return null;
        }else{
            System.out.print(this.prompt);
            return scanner.nextLine();
        }
    }
    public abstract void render();
}
