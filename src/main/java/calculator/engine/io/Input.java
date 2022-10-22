package calculator.engine.io;

import calculator.engine.model.UserSelection;

import java.util.List;

public interface Input {

    UserSelection getUserSelection(List<String> literals);

}
