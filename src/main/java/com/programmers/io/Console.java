package com.programmers.io;


import com.programmers.caculation.dto.CaculationControllerResponseDto;
import com.programmers.record.dto.RecordControllerResponseDto;

public class Console {
    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String getinputWithPrompt(String prompt) {
        showPrompt(prompt);
        return input.getinput();
    }

    public void showMenu() {
        output.showText("1.조회\n2.계산\n3.종료");
    }


    public void showCaculateResult(CaculationControllerResponseDto result) {
        output.showText(result.result);
    }


    public void showRecord(RecordControllerResponseDto record) {
        output.showText(record.allRecord);
    }

    public void showError(Exception e) {
        output.showText(e.getMessage());
    }


    public void showPrompt(String prompt) {
        output.showPrompt(prompt);
    }


}
