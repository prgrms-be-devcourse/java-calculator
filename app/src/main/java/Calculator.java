import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import calculation.ArithmeticLogicUnit;
import calculation.DivideByZeroException;
import calculation.Record;
import calculation.RecordRepository;
import input.Input;
import input.InputParser;

public class Calculator implements Runnable {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private final RecordRepository recordRepository;
	private final InputParser inputParser;
	private final ArithmeticLogicUnit arithmeticLogicUnit;

	public Calculator(InputParser inputParser, ArithmeticLogicUnit arithmeticLogicUnit,
		RecordRepository recordRepository) {
		this.inputParser = inputParser;
		this.arithmeticLogicUnit = arithmeticLogicUnit;
		this.recordRepository = recordRepository;
	}

	@Override
	public void run() {
		while (true) {
			try {
				switch (getSelection()) {
					case "1":
						printHistory();
						break;
					case "2":
						calculateAndPrintResult(br.readLine());
						break;
					case "3":
						return;
					default:
						continue;
				}
			} catch (DivideByZeroException e) {
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void printHistory() {
		List allRecord = recordRepository.findAllRecord();

		if (allRecord.isEmpty()) {
			System.out.println("히스토리가 없습니다");
		}
		allRecord.stream().forEach(System.out::println);
	}

	private String getSelection() throws IOException {
		System.out.println("1. 조회\n2. 계산\n3. 종료\n\n선택 : ");

		return br.readLine();
	}

	private void calculateAndPrintResult(String input) {

		Input in = new Input(input, inputParser);
		Record record = arithmeticLogicUnit.process(in);

		System.out.println(record.getResult());
		recordRepository.addRecord(record);

	}

}
