package com.programmers.view;

import com.programmers.domain.Menu;

/**
 * 출력
 */
public class Output {
    public static void printMenu(){
        for(Menu menu : Menu.values()){
            System.out.println(String.format("%d. %s",menu.getNum(),menu.getName()));
        }
        System.out.print("선택 : ");
    }

    //todo : 계산 후 결과 출력
    //todo : 조회 출력
    //todo : 종료 시 종료메시지 출력

}
