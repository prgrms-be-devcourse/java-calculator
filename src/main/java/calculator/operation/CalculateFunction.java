package calculator.operation;

@FunctionalInterface
public interface CalculateFunction<T> {

	T apply(T t1, T t2);
}
