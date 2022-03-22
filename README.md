# java_calculator
자바 계산기 구현 미션 Repository입니다.

## 자바 계산기
### 계산기 실행 방법
main/java/com/programmers/MainApplication.java 실행

### Entity
**CaseData.java**
- "1 + 2 + 3" 같은 입력값과 결과값을 가지고 있다.
- 엔티티 관련 로직들을 가지고 있다.

### Repository
**CaseRepository.java**
- Repository 인터페이스로 Repository 변경 가능성에 대비하여 생성

**MemoryRepository.java**
- 메모리 사용저장소 Repository 이다
- 순서 보장이 되는 store 라는 이름의 LinkedHashMap 메모리 저장소
- 레포지토리 관련 로직들을 가지고 있다.(데이터 저장 등)

### Service
**ValidationService.java**
- MainClass.java 에서 오류 발생을 검증한다.
- validationNumber 함수
  - 초기 입력 숫자 1인지 2인지 validation
- validationInput function
  - case0 : 띄어쓰기 안된경우 체크
  - case1 : 숫자가 입력되었는지 체크
  - case2 : 사칙 연산 문자열이 들어왔는지 체크case3 : 마지막에 연산자로 끝나는 경우 오류 발생으로 종료시켜버린다.(인덱식한 문제 합이 짝수)(1+2+3+ -> 인경우 index==6)

**CalculationService.java**
- calculate 함수
  - case1 = 숫자 1개만 입력한 경우
  - case2 = 계산 값을 출력해 준다.
    - +와-인 경우와 *와/인 케이스를 나눈 후 리스트를 값 , operation, 값 으로 잘라가면서 로직을 구현한다.
  - 최종적으로 출력 양식을 이쁘게하기 위해 소수 둘째자리까지 반올림한다.

**MainService.java**
- caseRepository 의 경우 repository 의 변경가능성을 고려하여 생성자로 연관성 주입을 연결하였다. 의존성 관리를 위해 AppConfig.java 파일을 만들어 팩토리패턴을 적용하였다.
- playCalculate 함수
  - 계산기가 실행되는 MainApplication 에서 사용될 함수이다.

## 메인함수 및 AppConfig
**AppConfig.java**
- 팩토리패턴을 적용시켜 MainApplication 의 Repository 를 MemoryRepository 로 연결합니다.
- 추가적인 개발로 Repository 변경이 있을시 AppConfig 에서 관리합니다.

**MainApplication.java**
- AppConfig 를 통해 의존성을 주입하고 실제 계산기 기능을 실행합니다.


### TDD 실행방법
test/java/com.programmers/repository<br>
test/java/com.programmers/service<br>

구현들을 테스트 가능한 구조로 코드작성하였습니다.

## 코드를 짜면서 아쉬웠던 점
- 계산 로직을 스택으로 짰으면 조금더 코드를 단순하고 짧으며 효율적으로 쓸수 있다고 생각한다.



### 요구사항

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

