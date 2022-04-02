package calculation;

public enum Operator {
	PLUS {
		public long operate(long op1, long op2) {
			return op1 + op2;
		}
	},
	MINUS {
		public long operate(long op1, long op2) {
			return op1 - op2;
		}
	},
	DIVIDE {
		public long operate(long op1, long op2) {
			if (op2 == 0) {
				throw new DivideByZeroException();
			}
			return op1 / op2;
		}
	},
	MULTIPLY {
		public long operate(long op1, long op2) {
			return op1 * op2;
		}
	};

	abstract public long operate(long op1, long op2);

}
