package engine;

import engine.io.Input;
import engine.io.Output;
import engine.model.Function;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Calculator implements Runnable {

    private Output output;
    private Input input;
    private Function function;

    @Override
    public void run() {
        while (true) {
            output.outputFunction(function);
            String inputString = input.inputFunction("선택 : ");
            Optional<Integer> inputFunctionNumber = function.check(inputString);
            if(inputFunctionNumber.isEmpty()){
                output.inputFunctionError();
                //break;
            }
        }
    }


}
