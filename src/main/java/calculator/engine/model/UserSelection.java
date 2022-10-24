package calculator.engine.model;

import calculator.application.io.enums.SelectOption;

public class UserSelection {
    private final SelectOption selection;

    public UserSelection(SelectOption selection) {
        this.selection = selection;
    }

    public boolean isEqualTo(SelectOption selectOption) {
        return selection.equals(selectOption);
    }
}
