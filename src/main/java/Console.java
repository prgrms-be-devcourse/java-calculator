import engine.io.Output;
import engine.model.Function;

public class Console implements Output {
    @Override
    public void outputFunction(Function function) {
        function.indexForEach(System.out::println);
        System.out.println(System.lineSeparator());
    }
}
