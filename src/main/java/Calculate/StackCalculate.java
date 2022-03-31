package Calculate;

import Calculator.Operation;
import Validator.RegularExpressionType;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StackCalculate implements Calculate{

    private Stack<Long> numberStack;
    private Stack<Operation> operationStack;

    @Override
    public long calc(String expression) {

        numberStack = new Stack<>();
        operationStack = new Stack<>();
        List<Long> numbers = stringArrToListLong(
                expression.split(RegularExpressionType.OPERATION_EXPRESSION.getRegExp())
        );
        List<Operation> operations = stringArrToListOperation(
                expression.split(RegularExpressionType.NUMBER_EXPRESSION.getRegExp())
        );
        init(numbers, operations);

        Iterator numberIter = numbers.iterator();

        for (Operation operation : operations) {
            pushOperation(operation);
            pushNumber(numberIter);
        }
        while (!operationStack.empty()) {
            StackCalc();
        }
        return numberStack.pop();
    }

    private void init(List<Long> numbers, List<Operation> operations) {
        numberStack.push(numbers.get(0));
        numbers.remove(0);
    }

    private void StackCalc() {
        Operation operation = operationStack.pop();
        long backNumber = numberStack.pop();
        long frontNumber = numberStack.pop();
        numberStack.push(operation.calc(frontNumber, backNumber));
    }

    private void pushNumber(Iterator numberIter) {
        if (numberIter.hasNext()) {
            long number = (long) numberIter.next();
            numberStack.push(number);
        }
    }

    private void pushOperation(Operation operation) {
        if (!operationStack.isEmpty()) {
            Operation topOperation = operationStack.peek();
            if (topOperation.getPriority() >= operation.getPriority()) {
                StackCalc();
            }
        }
        operationStack.push(operation);
    }

    private List<Long> stringArrToListLong(String[] numberString) {
        return Arrays.stream(numberString)
                .map(str -> str.replaceAll(" ",""))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private List<Operation> stringArrToListOperation(String[] operationString) {
        List<Operation> collect = Arrays.stream(operationString)
                .map(Operation::getOperation)
                .collect(Collectors.toList());
        collect.remove(0);
        return collect;
    }
}
