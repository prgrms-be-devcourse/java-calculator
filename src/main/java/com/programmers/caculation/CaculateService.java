package com.programmers.caculation;

import com.programmers.Service;
import com.programmers.caculation.caculator.Caculator;
import com.programmers.caculation.dto.CaculateResultDto;
import com.programmers.caculation.dto.ParseResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CaculateService implements Service {
    private Caculator caculator;
    public CaculateResultDto caculate(ParseResponseDto parseResponseDto) throws Exception {

        Double result = caculator.caculate(parseResponseDto.parsedExpression);
        return CaculateResultDto.from(result);
    }
}
