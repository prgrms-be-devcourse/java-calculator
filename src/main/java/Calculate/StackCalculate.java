package Calculate;

import Calculator.Operation;
import Calculator.OperationPriority;
import Validator.RegularExpressionType;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StackCalculate implements Calculate{

    @Override
    public long calc(String expression) {
        List<Long> numbers = stringArrToListLong(
                expression.split(RegularExpressionType.OPERATION_EXPRESSION.getRegExp())
        );
        List<Operation> operations = stringArrToListOperation(
                expression.split(RegularExpressionType.NUMBER_EXPRESSION.getRegExp())
        );
        Stack<Long> numberStack = init(numbers);
        Stack<Operation> operationStack = new Stack<>();

        Iterator numberIter = numbers.iterator();

        for (Operation operation : operations) {
            pushOperation(numberStack, operationStack, operation);
            pushNumber(numberIter, numberStack);
        }
        while (!operationStack.empty()) {
            stackCalc(numberStack, operationStack);
        }
        return numberStack.pop();
    }

    private Stack<Long> init(List<Long> numbers) {
        Stack<Long> numberStack = new Stack<>();
        numberStack.push(numbers.get(0));
        numbers.remove(0);
        return numberStack;
    }

    private void stackCalc(Stack<Long> numberStack, Stack<Operation> operationStack) {
        Operation operation = operationStack.pop();
        long backNumber = numberStack.pop();
        long frontNumber = numberStack.pop();
        numberStack.push(operation.calc(frontNumber, backNumber));
    }

    private void pushNumber(Iterator numberIter, Stack<Long> numberStack) {
        synchronized (this) {
            if (numberIter.hasNext()) {
                long number = (long) numberIter.next();
                numberStack.push(number);
            }
        }
    }

    private void pushOperation(Stack<Long> numberStack ,Stack<Operation> operationStack, Operation operation) {
        if (!operationStack.isEmpty()) {
            Operation topOperation = operationStack.peek();
            if (OperationPriority.compareByOperation(operation, topOperation)) {
                stackCalc(numberStack, operationStack);
            }
        }
        operationStack.push(operation);
    }

    private List<Long> stringArrToListLong(String[] numberString) {
        final String spacing = " ";
        final String noSpacing ="";
        return Arrays.stream(numberString)
                .map(str -> str.replaceAll(spacing,noSpacing))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private List<Operation> stringArrToListOperation(String[] operationString) {
        operationString = Arrays.copyOfRange(operationString, 1, operationString.length);
        List<Operation> collect = Arrays.stream(operationString)
                .map(Operation::getOperation)
                .collect(Collectors.toList());
        return collect;
    }
}
