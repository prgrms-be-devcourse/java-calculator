## 📌 계산기 TDD, OOP로 만들기 
### 다양한 표현 수식에 대한 사칙 연산을 수행하는 콘솔 기반의 계산기를 TDD와 OOP를 기반으로 구현해내는 프로젝트
- 메뉴 입력(0. 종료, 1. 조회, 2. 계산)을 받는 기능
- 이전 계산 이력에 대한 결과를 순서대로 조회하는 기능
- 수식(중위 표현식)을 입력 받아 계산 결과 값을 출력하는 기능
- 다양한 오류 처리 (메뉴 입력 오류, 표현 수식 오류)



<br>
 
## 👩‍💻 요구 사항과 구현 내용 
### 전체적인 클래스 관계 구조도
<img src="https://github.com/prgrms-be-devcourse/java-calculator/assets/71310074/910acf0d-8174-4cff-b801-ffe3a54c8914" width=700>



### 기능 구현

- 콘솔로 구현입니다.(스윙으로 구현하시는 분들 계실까봐) 
- 객체지향적인 코드로 계산기 구현하기
    - [x]  더하기
    - [x]  빼기
    - [x]  곱하기
    - [x]  나누기
    - [x]  우선순위(사칙연산)
- [x]  테스트 코드 구현하기
- [x]  계산 이력을 맵으로 데이터 저장기능 만들기
    - 애플리케이션이 동작하는 동안 데이터베이스 외에 데이터를 저장할 수 있는 방법을 고안해보세요.
- [x]  정규식 사용




## ✅ 피드백 반영사항

<details>
    <summary>첫번째 PR 반영사항</summary>

### 1. CalculatorApp
- 전략 패턴을 사용하여 CalculatorApp에서 구체적인 객체를 생성하여 `Calculator`에 주입합니다.
```java
        CalculatorConsole console = new CalculatorConsole();

        new Calculator(
                new PostfixCalculator(),
                new InfixToPostfixConverter(),
                console,
                console,
                new CalculationRepository()
        ).run();
```

### 2. 다양한 형태의 Converter 구현
- 다양한 수식 간의 변환을 가능하게 하는 `ExpressionConverter` 인터페이스로 추상화를 하고, 현재 계산기 프로그램에서는 중위 표현식을 후위 표현식으로 변환하는 `InfixToPosfixConverter` 클래스로 구현하여 동적으로 적절한 컨버터가 선택되도록 하였습니다.
- `convert()` 메서드에서 String 형태의 expression을 변환하여 피연산자와 연산자의 리스트 형태의 ArrayList<String> 타입으로 수식을 변환합니다.

### 3. Calculator 추상화
- 컨버터도 추상화할 수 있으면, 구체적인 표현식을 적절히 계산하여 계산 결과 값을 도출하는 계산기도 추상화할 수 있다고 생각하였습니다.
- 따라서 `calculate()` 추상 메소드를 포함하는 `BasicCalculator` 인터페이스로 추상화하고, 구체적으로 후위 표현 수식을 계산하는 `PostfixCalculator` 클래스로 구체화하였습니다.
- 마찬가지로 runnable한 Application에서 동작할 때, 계산 대상인 표현 수식에 따라 동적으로 적절한 Calculator가 선택됩니다.

### 4. Validation
- 기존에 Calculator 내에서 메뉴 선택, 표현 수식을 비롯한 입력에 대한 값 검증을 하던 `validateChoiceInput()`, `validateExpression()`의 메서드는 각각 Menu 클래스 내부, `CalculatorValidator` 클래스 내부로 이동하였습니다.
- 메서드 명 또한 valid 여부에 따라 boolean 타입을 반환한다는 점에서, 이를 잘 드러낼 수 있느 `isValidInputMenu()`, `isValidExpression()` 으로 변경하였습니다.

### 5. CalculationRepository - ConcurrentHashMap과 Atomic Variable을 통한 ID값 관리로 멀티 쓰레드 환경에서의 동시성 문제 고려
- 계산 이력을 저장하기 위해서 Map을 사용한 이유는, 추후 데이터베이스로의 확장 가능성을 생각했을 때, 각 레코드 별로 고유 PK ID값을 통해 CRUD를 편리하게 하는 것을 고려하여 각 계산 결과 객체 값에 대하여 Key 값을 Integer타입으로, 계산 결과 (CalculationResult)를 Value로 저장하도록 구현하였습니다.
- 기존에는 맵의 Key 값으로, 맵의 크기를 기반으로 id 값을 결정하였고 이는  데이터 삭제 로직으로 확장되는 경우를 고려하지 못했습니다.
- 쓰기 작업(put)에서 Lock을 통해 멀티 쓰레드 환경의 동시성 문제를 해결할 수 있는 ConccurrentHashMap을 이용하였습니다.
- 마찬가지로 유니크 아이디의 경우, 맵의 Key의 타입으로 AtomicInteger을 사용하였습니다.

### 6. ParameterizedTest 기반 유닛 테스트
- 단위 테스트 코드들을 작성하였고, ParameterizedTest를 통해 다양한 입력에 대한 테스트를 수행하였습니다.
- [ ] InfixToPostfixConverter 테스트에서 Failed 1개 발생
- [ ] 계산기 통합 테스트 Failed

### 7. 상수 관리
- 여러 클래스에서 사용되는 상수를 따로 하나의 클래스에서 관리하는 것은 객체 지향적이지 않다는 피드백을 바탕으로 각 클래스에서 사용하는 상수들은 클래스 내부로 옮겼습니다.

### 8. toString의 쓰임
- 디버그나 로깅 목적으로 toString이 사용된 다는 것을 새로 알게 되었고,
- `CalculationRepository`에 객체 저장 시에 `CalculationResult` 자체를 매개 변수로 넣어주도록 변경하였습니다.

### 9. Operation
- 사칙 연산을 수행하는 `Operation` 객체를 싱글톤으로 생성하도록 LazyHolder의 방식으로 구현하였습니다.
- [ ] Operation의 Converter, Calculator에서 모두 Operation을 필요로 한다는 점 -> static하게 사용할 수 있는 방법이 없을까? 고민하고 있습니다.. !
- [ ] 사칙 연산을 수행해내기 위해서는, String(+,-,*,/)과 Operator Enum 객체들을 Map으로 저장하는 `OperatorMap` 을 초기화하는 `Operation` 클래스의 객체가 필수적으로 생성되어야 하는데, Converter과 Calculator 모두 Operation에 의존성을 띄고 있어 설계 리팩토링을 진행해야 할 것 같습니다..

</details>

### 실행결과(콘솔)
```
1. 조회
2. 계산

선택 : 2

1 + 2
3

1. 조회
2. 계산

선택 : 2

1 + 2 * 3
7

1. 조회
2. 계산

선택 : 1

1 + 2 = 3
1 + 2 * 3 = 7

선택 : 2

3 - 2 * 2
-1
```

