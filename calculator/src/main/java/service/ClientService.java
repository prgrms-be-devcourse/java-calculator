package service;

import creator.CreatorManagement;
import entity.Expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ClientService {

    private final CalculatorService calcService
            = CreatorManagement.getCalcService();

    BufferedReader br;

    public ClientService() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }


    public void run() throws IOException {

        String selectView = "0. 종료\n1. 조회\n2. 계산\n\n선택 : ";
        boolean isRunning = true;

        while (isRunning) {

            // view console
            System.out.print(selectView);
            int command = Integer.parseInt(br.readLine());
            System.out.println();

            switch (command) {
                case 0:
                    System.out.println("계산기 앱을 종료 할게요!");
                    isRunning = false;
                    break;
                case 1:
                    List<Expression> histories = calcService.getHistory();

                    if (histories.size() == 0)
                        System.out.println("조회할 이력이 없습니다.");
                    else
                        histories.iterator().forEachRemaining(System.out::println);

                    System.out.println();
                    break;
                case 2:
                    String input = br.readLine();
                    double result = calcService.getResult(input);

                    // 검증 처리후 저장 및 출력 요구 3.25 체크
                    System.out.println(result + "\n");
                    calcService.saveInput(input, result);
                    break;
                default:
                    //에러처리
                    break;
            }

        }

    }

}
