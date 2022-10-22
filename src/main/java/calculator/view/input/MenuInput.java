package calculator.view.input;

public class MenuInput implements BaseInput {

    public Long inputMenuNumber() {
        return Long.parseLong(read());
    }
}
