package calculator.io;

import java.util.List;

public interface Output<T> {

	void requestInput();

	void output(String s);

	void printFormulas(List<T> t);

	void printAnswer(T t);

}
