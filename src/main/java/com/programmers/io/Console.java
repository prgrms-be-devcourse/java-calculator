package com.programmers.io;


import com.programmers.caculation.dto.CaculationControllerResponseDto;
import com.programmers.record.dto.RecordControllerResponseDto;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getinputWithPrompt(String prompt) {
        showPrompt(prompt);
        return scanner.nextLine();
    }

    public void showMenu() {
        showText("1.조회\n2.계산\n3.종료");
    }

    public void showCaculate() {
        showPrompt("식을 입력해 주세요 :");
    }

    @Override
    public void showCaculateResult(CaculationControllerResponseDto result) {
        showText(result.result);
    }

    @Override
    public void showRecord(RecordControllerResponseDto record) {
        showText(record.allRecord);
    }
    @Override
    public void showError(Exception e) {
        showText(e.getMessage());
    }

    @Override
    public void showPrompt(String prompt) {
        System.out.print(prompt);
    }

    @Override
    public void showText(String text) {
        System.out.println(text);
    }
}
