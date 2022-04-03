package console;

import arithmetic.ArithmeticOperations;
import save.SaveWithMap;

import java.util.Map;
import java.util.function.BiConsumer;

public class Output {
    private final Input input;
    private SaveWithMap saveWithMap;

    public Output(){
        input = new Input(this);
        saveWithMap = new SaveWithMap();
    }

    public void menuOutput(){
        System.out.println("1. 조회");
        System.out.println("2. 계산");

        System.out.print("선택 : ");
        input.menuInput();
    }

    public void calculateOutput(String string){
        StringManipulator stringManipulator = new StringManipulator(string);
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations(stringManipulator);
        Float result = arithmeticOperations.doArithmetic();

        saveWithMap.saveAtMap(string,result);

        System.out.println(result);
    }

    public void saveOutput(){
        Map<String,Float> resultMap = saveWithMap.getResultMap();
        BiConsumer<String, Float> biconsumer = (key, val) ->
                System.out.println(key + " = " + val);
        resultMap.forEach((s, aFloat) -> System.out.println(s + " = " + aFloat));
    }
}
