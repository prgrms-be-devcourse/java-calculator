# java_calculator
> 순수 자바로 OOP를 적용하여 계산기 만들기 - 김영주

## 요구사항

- [x] 사용자 입력으로 메뉴를 선택
- [x] 식을 입력받아 후위 연산식으로 변경
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 단일 내역을 저장하는 기능
- [x] 전체 내역을 조회하는 기능




## 실행결과(콘솔)
```
1.조회
2.계산
3.종료

메뉴를 입력해주세요(숫자만 입력) : 2

계산식을 입력하세요(자연수, 사칙연산, 공백 기준) : 3 + 5 * 2
계산 결과 : 13

1.조회
2.계산
3.종료

메뉴를 입력해주세요(숫자만 입력) : 2

계산식을 입력하세요(자연수, 사칙연산, 공백 기준) : 4 - 2 / 2 + 4 * 2
계산 결과 : 11

1.조회
2.계산
3.종료

메뉴를 입력해주세요(숫자만 입력) : 1
3 + 5 * 2 = 13
4 - 2 / 2 + 4 * 2 = 11

1.조회
2.계산
3.종료

메뉴를 입력해주세요(숫자만 입력) : 3

프로그램을 종료합니다.
```



## 주요 객체 목록

1. `클라이언트(view/)`
   - 입력(InputView.java)
     - 메뉴 입력
     - 계산식 입력
   - 출력(OutputView.java)
     - 응답받은 결과(내역 혹은 계산 값) 출력
2. `컨트롤러(controller/)`
   - 메뉴(MainController.java)
     - 메뉴 선택(조회 서비스, 계산 서비스)
3. `서비스(service/)`
   - 계산(Calculator.java)
     - 단일 계산 내역을 저장
     - 계산식 결과를 반환
4. `저장소(storage/)`
   - 계산 내역 저장소(HistoryStorage.java)
     - Map을 이용해 저장
     - 정상과 예외 내역 모두 저장
     - 조회 시, 전체 계산 내역 반환
5. `엔티티(entity/)`
   - 메뉴(Menu.java)
     - 조회, 계산, 종료
     - 선택한 메뉴 번호에 따라 메뉴를 반환
   - 연산자(Operator.java)
     - 사칙연산(+, -, *, /)
     - 연산자 우선순위에 따라 연산
     - 나눗셈을 할 때 제수가 0이면 안됨
   - 식(Expression.java)
     - 피연산자 2개
     - 연산자 1개
     - 작은 식(ex. 3 + 5) 단위의 결과값 반환
   - 표기법(Notation.java)
     - 중위표현식(InfixNotation.java)
     - 후위표현식(PostfixNotation.java)
6. `예외처리(exception/)`
   - 메뉴 예외
     - 존재하지 않는 메뉴 선택
     - 아무것도 입력하지 않음 (입력값을 trim 처리했을 때 공백인 경우)
   - 수식 예외
     - 연산자 개수 부족
     - 피연산자 개수 부족
     - 연산자 값이 올바르지 않음 (사칙연산 이외의 기호가 입력된 경우)
     - 피연산자 값이 올바르지 않음 (숫자가 아닌 경우, 피연산자와 연산자가 붙어있는 경우)
     - 너무 큰 숫자일 경우 (추후 추가 사항)
     - 괄호 짝이 맞지 않음(추후 추가 사항)
   - 계산 예외
     - 나눗셈의 제수가 0인 경우



## 프로그램 구조도

![image](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fb33dec55-c288-45fc-9c6c-20bd669ca9c6%2FUntitled.png?table=block&id=143ebc12-a4d1-49aa-ad0c-0599926d6299&spaceId=a592f9c1-ca11-4018-a4f6-7dbbcd6b008e&width=2000&userId=55d7c337-b594-4735-9e25-4588aa133d55&cache=v2)

![image](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F81cb2325-93dc-430b-bc82-31b85f7c52e0%2FUntitled.png?table=block&id=4caeb1b6-1ed3-402e-955c-0f002c7277fc&spaceId=a592f9c1-ca11-4018-a4f6-7dbbcd6b008e&width=2000&userId=55d7c337-b594-4735-9e25-4588aa133d55&cache=v2)



## 패키지 구조

```
src/main/java/calculator/
- view/
	- InputView.java
	- OutputView.java

- controller/
	- MainController.java

- service/
	- Calculator.java

- storage/
	- HistoryStorage.java

- entity/
	- Menu.java
	- Operator.java
	- Expression.java
	- Notation.java
	- InfixNotation.java
	- PostfixNotation.java

- exception/
	- MenuInputException.java
	- ExpressionInputException.java

- utils/
	- StringUtils.java
```



## Git commit convention

> [Angular JS commit convention](https://velog.io/@outstandingboy/Git-커밋-메시지-규약-정리-the-AngularJS-commit-conventions)를 참고

```markdown
[커밋 메시지 헤더]
<type>(<scope>): <short summary>
  │       │             │
  │       │             └─⫸ 현재 시제로 작성한다. 마침표로 끝내지 않는다.
  │       │
  │       └─⫸ Commit Scope: 어느 부분을 수정했는지 작성한다.(생략 가능)
  │
  └─⫸ Commit Type: build|docs|feat|fix|refactor|test|style

[커밋 메시지 바디]
- 현재 시제로 작성한다.
- 변경 전과 후의 차이점과 이유에 대해 작성한다.
```

- `feat` : 새로운 기능 추가
- `fix` : 버그 수정
- `docs` : 문서 관련
- `style` : 스타일 변경 (포매팅 수정, 들여쓰기 추가, …)
- `refactor` : 코드 리팩토링
- `test` : 테스트 관련 코드
- `build` : 빌드 관련 파일 수정
