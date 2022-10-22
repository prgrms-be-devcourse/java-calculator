package calculator.view.input;

public class MenuInput implements BaseInput {

    public Long askMenuId() {
        return Long.parseLong(read());
    }
}
