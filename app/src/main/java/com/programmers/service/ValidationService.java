package com.programmers.service;

import java.util.StringTokenizer;

public class ValidationService {
    // 입력 숫자 1인지 2인지 validation
    public boolean validationNumber(int number) {
        
        if (number != 1 && number != 2) {
            return false;
        }
        return true;
    }

    // Input 양식 체크
    public boolean validationInput(String input) {
        
        StringTokenizer st = new StringTokenizer(input);
        int index = 0; // 홀수 짝수 를 통해 숫자와 문자열 인지( 1 + 2 + 3 + 4)

        while (st.hasMoreTokens()) {
            index++; // 인덱스 1씩 증가
            String oneInput = st.nextToken();

            // case0 : 띄어쓰기 안된경우 체크
            if (oneInput.length() != 1) {
                return false;
            }

            // case1 : 숫자가 입력되었는지 체크
            if (checkNumber(index, oneInput)) {
                return false;
            }

            // case2 : 사칙 연산 문자열이 들어왔는지 체크
            if (checkOperation(index, oneInput)) {
                return false;
            }
        }
        // case3 : 마지막에 연산자로 끝나는 경우 오류 발생으로 종료시켜버린다.(인덱식한 문제 합이 짝수)(1+2+3+ -> 인경우 index==6)
        if (index % 2 == 0) {
            return false;
        }
        return true;
    }

    private boolean checkNumber(int index, String oneInput) {
        // case1 : 숫자가 입력되었는지 체크
        char tmp;

        if (index % 2 == 1) {
            for (int i = 0; i < oneInput.length(); i++) {
                tmp = oneInput.charAt(i);

                if (!('0' <= tmp && tmp <= '9')) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkOperation(int index, String oneInput) {
        // case2 : 사칙 연산 문자열이 들어왔는지 체크
        if (index %2==0){
            if (!(oneInput.equals("+") | oneInput.equals("-") | oneInput.equals("*") | oneInput.equals("/"))) {
                return true;
            }
        }
        return false;
    }
}
