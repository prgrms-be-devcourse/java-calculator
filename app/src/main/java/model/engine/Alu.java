package model.engine;

import model.history.Record;
import model.input.Input;

public interface Alu {

	Record process(Input input);
}
