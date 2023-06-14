# java_calculator
자바 계산기 구현 미션 Repository입니다.

<details>
    <summary>PR 반영한 점</summary>

1. CalculatorApp
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

2. 다양한 형태의 Converter 구현
- 중위 표현식에서 후위 표현식을 바꿔주는 컨버터 뿐 아니라, 후위 표현식을 중위 표현식으로 변환하는 등의 다양한 수식 간의 변환을 가능하게 하는 `ExpressionConverter` 인터페이스로 추상화를 하고, 구상체인 `InfixToPosfixConverter` 클래스로 구현하여 동적으로 적절한 컨버터가 선택되도록 하였습니다.
- `convert()` 메서드에서 String 형태의 expression을 변환하여 피연산자와 연산자의 리스트 형태의 ArrayList<String> 타입으로 수식을 변환합니다.

3. Calculator 추상화
- 컨버터도 추상화할 수 있으면, 구체적인 표현식을 적절하게 계산하는 계산기도 추상화할 수 있다고 생각하였습니다.
- 따라서 실제 표현식을 계산하는 `calculate()` 메서드를 담는 `BasicCalculator` 인터페이스로 추상화하고, 구체적으로 후위 표현 수식을 계산하는 `PostfixCalculator` 클래스로 구체화하였습니다.
- 마찬가지로 runnable한 Application에서 동작할 때, 계산 대상인 표현 수식에 따라 동적으로 적절한 Calculator가 선택됩니다.

4. Validation
- 기존에 Calculator 내에서 메뉴 선택, 표현 수식을 비롯한 입력에 대한 값 검증을 하던 `validateChoiceInput()`, `validateExpression()`의 메서드는 각각 Menu 클래스 내부, `CalculatorValidator` 클래스 내부로 이동하였습니다.
- 메서드 명 또한 valid 여부에 따라 boolean 타입을 반환한다는 점에서, 이를 잘 드러낼 수 있느 `isValidInputMenu()`, `isValidExpression()` 으로 변경하였습니다.

5. CalculationRepository - ConcurrentHashMap과 Atomic Variable을 통한 ID값 관리로 멀티 쓰레드 환경에서의 동시성 문제 고려
- 계산 이력을 저장하기 위해서 Map을 사용한 이유는, 추후 데이터베이스로의 확장 가능성을 생각했을 때, 각 레코드 별로 고유 PK ID값을 통해 CRUD를 편리하게 하는 것을 고려하여 각 계산 결과 객체 값에 대하여 Key 값을 Integer타입으로, 계산 결과 (CalculationResult)를 Value로 저장하도록 구현하였습니다.
- 기존에는 맵의 Key 값으로, 맵의 크기를 기반으로 id 값을 결정하였고 이는  데이터 삭제 로직으로 확장되는 경우를 고려하지 못했습니다.
- 쓰기 작업(put)에서 Lock을 통해 멀티 쓰레드 환경의 동시성 문제를 해결할 수 있는 ConccurrentHashMap을 이용하였습니다.
- 마찬가지로 유니크 아이디의 경우, 맵의 Key의 타입으로 AtomicInteger을 사용하였습니다.

6. ParameterizedTest 기반 유닛 테스트
- 단위 테스트 코드들을 작성하였고, ParameterizedTest를 통해 다양한 입력에 대한 테스트를 수행하였습니다.
- [ ] InfixToPostfixConverter 테스트에서 Failed 1개 발생
- [ ] 계산기 통합 테스트 Failed

7. 상수 관리
- 여러 클래스에서 사용되는 상수를 따로 하나의 클래스에서 관리하는 것은 객체 지향적이지 않다는 피드백을 바탕으로 각 클래스에서 사용하는 상수들은 클래스 내부로 옮겼습니다.

8. toString의 쓰임
- 디버그나 로깅 목적으로 toString이 사용된 다는 것을 새로 알게 되었고,
- `CalculationRepository`에 객체 저장 시에 `CalculationResult` 자체를 매개 변수로 넣어주도록 변경하였습니다.

9. Operation
- 사칙 연산을 수행하는 `Operation` 객체를 싱글톤으로 생성하도록 LazyHolder의 방식으로 구현하였습니다.
- [ ] Operation의 Converter, Calculator에서 모두 Operation을 필요로 한다는 점 -> static하게 사용할 수 있는 방법이 없을까? 고민하고 있습니다.. !
- [ ] 사칙 연산을 수행해내기 위해서는, String(+,-,*,/)과 Operator Enum 객체들을 Map으로 저장하는 `OperatorMap` 을 초기화하는 `Operation` 클래스의 객체가 필수적으로 생성되어야 하는데, Converter과 Calculator 모두 Operation에 의존성을 띄고 있어 설계 리팩토링을 진행해야 할 것 같습니다..

</details>
 

### 이곳은 공개 Repo입니다.
1. 여러분의 포트폴리오로 사용하셔도 됩니다.
2. 때문에 이 repo를 fork한 뒤
3. 여러분의 개인 Repo에 작업하며 
4. 이 Repo에 PR을 보내어 멘토의 코드 리뷰와 피드백을 받으세요.

### Branch 명명 규칙 + 팀의 PR규칙 정하기
1. 여러분 repo는 알아서 해주시고 😀(본인 레포니 main으로 하셔두 되져)
2. prgrms-be-devcourse/spring-board 레포로 PR시 branch는 gituser_id을 적어주세요 :)  
    - base repo : `여기repo` base : `username` ← head repo : `여러분repo` compare : `main`또는 `github_id`
3. 실제 진행할 PR규칙은 멘토+팀원들과 정하여 진행해주세요 :) 
    - ← head repo : `여러분repo` compare : `main`로 할지
    - 또는 ← head repo : `여러분repo` compare : `github_id`로 할지
- 참고 : [Github 위치 및 피드백 기준 가이드](https://www.notion.so/backend-devcourse/Github-e1a0908a6bbf4aeaa5a62981499bb215)

### 과제를 통해 기대하는 역량

- 깃허브를 통한 코드리뷰를 경험해보자
- 기본적인 테스트 코드 작성 및 활용하는 능력해보자
- 스스로 OOP를 생각하고 코드로 옮길 수 있는 능력해보자

### 요구사항
- 콘솔로 구현입니다.(스윙으로 구현하시는 분들 계실까봐) 
- 객체지향적인 코드로 계산기 구현하기
    - [ ]  더하기
    - [ ]  빼기
    - [ ]  곱하기
    - [ ]  나누기
    - [ ]  우선순위(사칙연산)
- [ ]  테스트 코드 구현하기
- [ ]  계산 이력을 맵으로 데이터 저장기능 만들기
    - 애플리케이션이 동작하는 동안 데이터베이스 외에 데이터를 저장할 수 있는 방법을 고안해보세요.
- (선택) 정규식 사용

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

