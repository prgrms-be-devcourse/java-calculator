package engine;

import engine.io.Output;
import engine.model.Function;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {

    private Output output;
    private Function function;

    @Override
    public void run() {
        while (true) {
            output.outputFunction(function);
            break;
        }
    }
}
