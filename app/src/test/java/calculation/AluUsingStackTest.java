package calculation;

import input.Input;
import input.InputParser;
import input.InputParserWithBlank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AluUsingStackTest {

	private final Alu myAlu;
	private final InputParser inputParser;
	private Input divideByZeroInput;


	public AluUsingStackTest() {
		this.myAlu = new AluUsingStack();
		this.inputParser = new InputParserWithBlank();
	}

	@BeforeEach
	public void setUp(){
		divideByZeroInput = new Input("1 + 3 / 0", inputParser);

	}
	@Test
	public void 문자열_배열을_받아_계산하기() {
		Input input = new Input("1 + 3 * 2", inputParser);
		Assertions.assertEquals("7", myAlu.process(input).getResult());
	}

	@Test
	public void 롱타입_계산_확인하기() {
		Input input = new Input("1000000 * 10000000", inputParser);
		Assertions.assertEquals("10000000000000", myAlu.process(input).getResult());
	}

	@Test
	public void 나눗셈이포함된_연산_계산하기() {
		Input input = new Input("1 + 4 / 2", inputParser);
		Assertions.assertEquals("3", myAlu.process(input).getResult());
	}

	@Test
	public void 여러_연산이_포함된_연산_계산하기(){
		Input input = new Input("5000 + 100 / 2 + 1", inputParser);
		Assertions.assertEquals("5051",myAlu.process(input).getResult());

	}

	@Test
	public void 연산_순서_확인_케이스_앞에서부터(){
		Input input = new Input("5000 + 100 / 2 * 2", inputParser);
		Assertions.assertEquals("5100",myAlu.process(input).getResult());
	}


	@Test
	public void 예외상황_0으로_나눈_경우_예외를던진다(){
		Assertions.assertThrows(DivideByZeroException.class, () -> myAlu.process(divideByZeroInput));
	}


}
