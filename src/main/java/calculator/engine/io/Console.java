package calculator.engine.io;

public class Console {
    private final Input reader;
    private final Output output;

    public Console() {
        this.reader = new Input();
        this.output = new Output();
    }

    public void getUserSelection() {
//        output.printSelectOption(SelectOption.getLiterals());
//        reader.readSelection();
    }
}
