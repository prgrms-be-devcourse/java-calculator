# java_calculator


## 2차 pr에서 수정한 부분

### 1. Util 클래스 최소화 및 도메인에 책임 넘기기
- Operator 도메인 클래스(Enum)를 만들어 +,-,*,/ 연산 책임 넘기기 
- Coverter 함수 삭제 후 계산식(String expression)의 연산 과정을 CalculatorProcessor에서 모두 처리할 수 있도록 수정

### 2. 사칙연산 계산 방식 변경

- 기존방식
  - 식(후위표기식)을 입력 받고 -> 중위표기식으로 변환 -> 중위표기식을 Stack을 이용해 계산
- 수정 후 방식
  - operators, operands 각각 Deque을 사용해 우선순위 비교하여 사칙연산 계산 

### 3. repository 확장성 고려
- 추후 Map이 아닌 다른 DB를 사용할 수 있는 점을 고려하여 Interface 추가
- LinkedHashMap을 데이터 저장소로 사용하는 사용하는 구현체 MapCalculatorRepository로 생성

### 4. 사용자 정의 에러 사용하여 예외 고려

- CalculatorException으로 발생하는 예외 처리 
- ErrorMessage : 발생할 수 있는 예외 모아놓은 Enum 클래스
- ConsoleMessage : 이 계산기에서는 입력값이 잘못된 경우 다시 입력 받도록 출력하는 안내 메시지 Enum 클래스

### 5. 테스트 코드 작성

### 6. 피드백 수정 
```- 적절한 변수 사용해서 Main 함수의 Controller 생성 코드 수정```

```- 모든 출력문은 Output 메소드를 이용하도록 코드 수정```

```
- 메소드 명, 클래스 명 수정
  - CalculatorDto -> model 패키지의 ExpressionResult로 수정
  - CalculationHelper -> CalculationProcessor로 클래스 명 수정
  ```

```- IdGenerator Static 하게 수정```

```- Pattern 객체 static 변수로 수정```

```- Input 클래스에서 입력 함수(inputLine()), 처리 함수(processMenu(),processExpression()) 구분하는 것으로 수정```

```- 반복시 try-catch문 -> while문 사용하여 코드 수정```

---

  

### 요구사항
- 객체지향적인 코드로 계산기 구현하기
    - [x]  더하기
    - [x]  빼기
    - [x]  곱하기
    - [x]  나누기
    - [x]  우선순위(사칙연산)
- [x]  테스트 코드 구현하기
- [x]  계산 이력을 맵으로 데이터 저장기능 만들기
    - 애플리케이션이 동작하는 동안 데이터베이스 외에 데이터를 저장할 수 있는 방법을 고안해보세요.
- [x] 정규식 사용

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

