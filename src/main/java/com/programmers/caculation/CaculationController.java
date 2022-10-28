package com.programmers.caculation;

import com.programmers.Controller;
import com.programmers.caculation.dto.*;
import com.programmers.caculation.model.Expression;
import com.programmers.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor
public class CaculationController implements Controller {
    private HistoryRepository  historyRepository;
    private final TokenizeService tokenizeService;
    private final ParseService parseService;
    private final CaculateService caculateService;
    public CaculationControllerResponseDto caculate(String input) throws Exception{
        String inputExpression = input.replace(" ","");
        TokenizeRequestDto tokenizeRequestDto= TokenizeRequestDto.from(inputExpression);
        TokenizeResponseDto tokenizeResponseDto = tokenizeService.tokenize(tokenizeRequestDto);
        ParseResponseDto parseResponseDto = parseService.parseRequest(tokenizeResponseDto.value);
        CaculateResultDto caculateResultDto= caculateService.caculate(parseResponseDto);
        Expression expression= new Expression(inputExpression,caculateResultDto.value);
        historyRepository.addData(expression.getAllExpression());
        return CaculationControllerResponseDto.from(expression.getResult());
    }
}
