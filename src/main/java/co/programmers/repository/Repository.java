package co.programmers.repository;

import java.util.Map;

public interface Repository {
	void save(String expression, Double result);

	Map<String, Double> read();
}
