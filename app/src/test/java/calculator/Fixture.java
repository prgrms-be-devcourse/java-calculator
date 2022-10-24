package calculator;

import calculator.domain.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fixture {
    public static String EXP_OF_DIV_BY_0 = "2 / 0";
    public static String EXP_OF_ADD_N_MIN = "1 + 1 - 5";
    public static int ANSWER_OF_ADD_N_MIN = -3;
    public static String EXP_OF_DIV_N_MUL = "2 * 3 / 4";
    public static int ANSWER_OF_DIV_N_MUL = 1;
    public static String EXP_OF_ADD_N_DIV = "2 + 4 / 4";
    public static int ANSWER_OF_ADD_N_DIV = 3;
    public static String EXP_OF_BRACKET = "2 * (3 + 5)";
    public static int ANSWER_OF_BRACKET = 16;
    public static int LEN_OF_INTRO_N_CMD(){
        String introduction = "\n\n" + "선택 : n\n";
        for (Command c : Command.values()) {
            introduction = introduction.concat(c.getCode() + ". " + c.getCommand() + "\n");
        }
        return introduction.length();
    }

    public static String STRING_OF_DATA = "1+1=2"+ "\n" + "2+2=4" + "\n" + "3+3=6" + "\n";
    public static List<String> LIST_OF_DATA(){
        return Arrays.asList("1+1=2", "2+2=4", "3+3=6");
    }

    public static List<String> EMPTY_LIST_OF_DATA(){
        return new ArrayList<>();
    }

    public static String GETALLDATA_NO_DATA_TO_GET = "> 조회할 데이터가 없습니다";
    public static String EXIT_PROGRAM= "> 계산기 프로젝트를 종료합니다";
    public static String CALCULATE_DIV_BY_0 = "> 0으로 나눌 수 없습니다. 다시 입력해주세요";
    public static String WRONG_COMMAND= "> 다시 입력해주세요";
    public static int NEG_FOR_EXIT = 1;
}
