package com.programmers.pages;


import java.util.Optional;
public class StartPage extends Page {


    public StartPage(String content, String prompt, PageList nextPage) {
        super(content, prompt, nextPage);
    }

    @Override
    public void run() {
        while (true) {
            String inputString;
            outputData(getContent());
            inputString = input(getPrompt());
            Optional<String> parsedInput = this.parse(inputString);

            if (parsedInput.isEmpty()) {
                inputError();
                continue;
            }
            if (parsedInput.get().equals("1")) {
                setNextPage(PageList.LOOKUP);
                break;
            }
            if(parsedInput.get().equals("2")){
                setNextPage(PageList.CALCULATE);
                break;
            }

        }

    }

    @Override
    protected Optional<String> parse(String inputString) {
        return switch (inputString) {
            case "1" -> Optional.of("1");
            case "2" -> Optional.of("2");
            default -> Optional.empty();
        };
    }
}
