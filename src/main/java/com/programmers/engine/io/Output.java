package com.programmers.engine.io;

public interface Output  {
    default void error(){
        System.out.println("잘못된 입력입니다!");
    };
    default void error(String errorMessage){
        System.out.println(errorMessage);
    }
    default void outputData(Object data){
        System.out.println(data.toString());
    };
}
