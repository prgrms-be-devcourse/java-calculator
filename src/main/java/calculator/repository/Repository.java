package calculator.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends FormulaResult, I> {
	void save(T data);

	Optional<T> findOne(I id);

	List<T> findAll();

}
