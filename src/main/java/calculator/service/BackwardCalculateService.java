package calculator.service;

import calculator.dto.Calculation;
import calculator.repository.CalculateRepository;
import calculator.util.Operations;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

//후위표현식을 활용하는 계산을 구현한 클래스
//아직 2자리수 이상의 숫자와 double형을 계산하지 못합니다.
public class BackwardCalculateService implements CalculateService{

    private final CalculateRepository calculateRepository;

    public BackwardCalculateService(CalculateRepository calculateRepository) {
        this.calculateRepository = calculateRepository;
    }

    @Override
    public void save(Calculation calculation) {
        calculateRepository.save(calculation);
    }

    @Override
    public List<Calculation> history() {
        return calculateRepository.findAll();
    }

    @Override
    public int calculate(String equation) {
        String backwardEquation = makeBackward(equation);
        return calculateBackward(backwardEquation);
    }

    //중위표현식을 후위표현식으로 변환
    private String makeBackward(String equation){
        //연산자들이 쌓이는 stack
        Stack<String> stack = new Stack<>();
        //최종 후위표현식 결과
        StringBuilder result = new StringBuilder();
        //피연산자들이 임시로 들어가있는 stringBuilder
        StringBuilder nums = new StringBuilder();

        //중위표현식을 후위표현식으로 변환
        //이렇게 람다식에 코드 양이 많다면 차라리 for문으로 작성하는게 더 나을까요?
        Arrays.stream(equation.split(""))
            .forEach(s -> {
                if(Operations.isOperator(s)){
                    result.append(nums);
                    nums.delete(0, nums.length());
                    if(stack.empty()){
                        stack.push(s);
                    } else{
                        if(Operations.isBigger(s, stack.peek())){
                            stack.push(s);
                        } else{
                            result.append(stack.pop());
                            stack.push(s);
                        }
                    }
                } else{
                    nums.append(s);
                }
            });

        //남아있는 피연산자와 연산자를 result에 추가
        result.append(nums);
        while(!stack.empty()){
            result.append(stack.pop());
        }
        return result.toString();
    }

    //후위표현식을 통해 계산
    private int calculateBackward(String backward){
        Stack<String> stack = new Stack<>();
        String[] split = backward.split("");
        AtomicInteger sum = new AtomicInteger();

        Arrays.stream(split)
            .forEach(s -> {
                if(Operations.isOperator(s)){
                    int operatedBy = Integer.parseInt(stack.pop());
                    int operand = Integer.parseInt(stack.pop());
                    int result = Operations.calculate(operand, s, operatedBy);
                    stack.push(Integer.toString(result));
                    sum.set(result);
                } else{
                    stack.push(s);
                }
            });
        return sum.get();
    }

}
