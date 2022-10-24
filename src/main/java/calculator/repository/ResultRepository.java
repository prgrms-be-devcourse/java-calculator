package calculator.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum ResultRepository implements Repository {

	REPOSITORY,
	;

	private static final Map<String, String> map = new LinkedHashMap<>();

	@Override
	public void save(String formula, String answer) {
		map.put(formula, answer);
	}

	@Override
	public String find(String formula) {
		return map.get(formula);
	}

	@Override
	public boolean isExist(String formula) {
		return map.containsKey(formula);
	}

	@Override
	public List<String> findAll() {
		List<String> list = new ArrayList<>();
		map.forEach((key, value) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(key).append(" = ").append(value);
			list.add(sb.toString());
		});

		return list;
	}

}
