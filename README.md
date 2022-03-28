# java_calculator
**자바 계산기 구현 미션 Repository / 김수미**
<br><br>

## ✔️ 과제 요구사항
- [x]  더하기
- [x]  빼기
- [x]  곱하기
- [x]  나누기
- [x]  사칙연산 우선순위 규칙 적용
- [x]  계산 이력을 맵으로 데이터 저장기능 만들기(인메모리 DB)
- [x]  객체지향적 코드 작성
- [ ]  테스트 코드 구현
<br><br>

## ✔️ 과제 구현 결과
계산기 코드의 구조는 아래와 같습니다.
```
 calculator
    ├── App.java
    ├── Console.java
    └── engine
        ├── Calculator.java
        ├── io
        │   ├── Input.java
        │   └── Output.java
        └── model
            ├── History.java
            └── Symbols.java
```
- **Calculate.java** : 핵심 클래스로 계산식 연산 및 데이터 저장을 담당합니다.
- **In/Output.java** : 입출력을 위한 인터페이스 입니다.
- **History.java** : 입력받은 계산식과, 계산 결과 객체를 관리합니다.
- **Symbols.java** : 입력받은 계산식의 연산자와 피연산자를 관리합니다.
<br><br>

## ✔️ PR 포인트 & 궁금한 점
- 객체별로 분리하려고 노력했으나, 분리하는 과정에서 객체를 생성하고 할당하는 과정이 불필요하게 반복된다는 느낌이 들었습니다.
- 예를 들면 아래 코드에서, Symbols 클래스가 없어도 생성한 operands, operators ArrayList 만으로 코드를 이어 작성할 수 있습니다.

```java
 List<Double> operands = new ArrayList<Double>();
 List<String> operators = new ArrayList<String>();
 for (int i = 0; i < newString.length; i += 2) operands.add(Double.parseDouble(newString[i]));
 for (int i = 1; i < newString.length; i += 2) operators.add(newString[i]);
 Symbols symbols = new Symbols(operands,operators);
```

- 이번주차 Java 강의를 최대한 참고하여 코드를 작성하려고 노력했는데, 제가 불필요한 클래스를 만들고 있는 것일까요?
- 아니면 이후 코드 유지보수를 위해 이렇게 작성하는 것이 알맞은 객체지향 프로그래밍인 것인가요?
- commit 또한 전체를 하나의 평면적인 코드로 작성하는것에 익숙하다 보니 적합한 시기를 잘 모르겠습니다. commit 의 시기는 언제가 적합한가요?
<br><br>

## ✔️ 피드백 관련사항
- 테스트 코드를 아직 작성하지 못했는데, 객체지향적 구현이 어느정도 다듬어진 후에 작성하고 싶어 일단 코드만 제출하겠습니다.
- 아직 java 언어와 객체지향 개념에 익숙하지 않아, 많은 흠이 있는 코드라고 생각합니다.
- 또한 평면적인 코드만 작성하다가 depth가 있는 코드를 작성하려니 많은 부분이 헷갈립니다.
- 어떤 부분이라도 따끔하게 조언 주시면 감사하겠습니다!🥺
<br><br>
