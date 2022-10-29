package calculator.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ResultRepository implements Repository<FormulaResult, String> {

	private static final Map<String, FormulaResult> map = new LinkedHashMap<>();

	@Override
	public void save(FormulaResult data) {
		map.put(data.getFormula(), data);
	}

	@Override
	public Optional<FormulaResult> findOne(String s) {
		return Optional.ofNullable(map.get(s));
	}

	@Override
	public List<FormulaResult> findAll() {
		return new ArrayList<>(map.values());

	}
}
