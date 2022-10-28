package com.programmers.io;

import com.programmers.caculation.dto.CaculationControllerResponseDto;
import com.programmers.record.dto.RecordControllerResponseDto;

public interface Output {

    public void showPrompt(String prompt);

    public void showText(String text);

    void showCaculateResult(CaculationControllerResponseDto result);

    void showRecord(RecordControllerResponseDto record);


    public void showError(Exception e);
}
