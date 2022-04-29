package calculator.console;

import calculator.dto.RequestDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private final BufferedReader br;

    public Console() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public RequestDto input() throws IOException {
        RequestDto requestDto = new RequestDto();
        System.out.print("1. 조회\n2. 계산\n\n선택 : ");

        Integer request = Integer.valueOf(br.readLine());
        requestDto.setRequest(request);
        System.out.println();

        if(request == 2) {
            String expr = br.readLine();
            requestDto.setExpr(expr);
        }

        return requestDto;
    }

    public void print(String output) {
        System.out.println(output);
    }
}