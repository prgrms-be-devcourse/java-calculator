# java_calculator
자바 계산기 구현 미션 Repository입니다.

## 이곳은 공개 Repo입니다.
1. 여러분의 포트폴리오로 사용하셔도 됩니다.
2. 때문에 이 repo를 fork한 뒤
3. 여러분의 개인 Repo에 작업하며 
4. 이 Repo에 PR을 보내어 멘토의 코드 리뷰와 피드백을 받으세요.

## Branch 명명 규칙
1.  여러분 repo는 알아서 해주시고 😀(본인 레포니 main으로 하셔두 되져)
2.  prgrms-be-devcourse/spring-board 레포로 PR시 branch는 gituser_id을 적어주세요 :)  
- base repo : `여기repo` base : `username` ← head repo : `여러분repo` compare : `main`또는 `github_id`
- 이 규칙은 멘토+팀원들과 정하여 진행해주세요 :) 
- 참고 : [Github 위치 및 피드백 기준 가이드](https://www.notion.so/backend-devcourse/Github-e1a0908a6bbf4aeaa5a62981499bb215)

### 과제를 통해 기대하는 역량

- 깃허브를 통한 코드리뷰를 경험해보자
- 기본적인 테스트 코드 작성 및 활용하는 능력해보자
- 스스로 OOP를 생각하고 코드로 옮길 수 있는 능력해보자

### 요구사항

- 객체지향적인 코드로 계산기 구현하기
    - [ ]  더하기
    - [ ]  빼기
    - [ ]  곱하기
    - [ ]  나누기
    - [ ]  우선순위(사칙연산)
- [ ]  테스트 코드 구현하기
- [ ]  계산 이력을 맵으로 데이터 저장기능 만들기(인메모리 DB)
- (선택) 정규식 사용

### 구현 기능 목록

- UI
  - 입력
    - [X] 메뉴 입력
      - [X] 정상 입력
      - [X] 1, 2 이외의 입력 예외처리
    - [X] 계산식 입력
      - [X] 정상 상황 입력 
      - [X] 정규식 사용해 예외처리
  - 출력
    - [X] 메뉴 출력
    - [X] 계산 결과 출력
    - [X] 조회 결과 출력
- 핵심기능 
  - 사칙연산
    - 사칙연산(우선순위)
      - [X] 덧셈
      - [X] 뺄셈
      - [X] 나눗셈
      - [X] 곱셈
      - [X] 문자열 수식을 후위 표기법으로 바꾸기
      - [X] 후위 표기식 계산하기
  - [X] 계산 이력을 맵으로 데이터 저장 기능

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
### commit convention

- [AngularJS commit conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#format-of-the-commit-message)

### java convention

- [google convention](https://google.github.io/styleguide/javaguide.html)

### 1차 피드백
- [X] .gitignore도 깔끔하게 관리하기
- [X] 사칙연산 enum을 이용한 전략패턴으로 구현해보기
- [X] matches는 비싼 행위 대안 생각해보기
- [X] 한 메서드에 Depth가 많으면 리펙토링 요소. depth가 많으면 분리해보기
- [X] menu도 enum으로 관리해보기
- [X] 과연 scanner를 컨트롤러에서 넣어주는게 맞는걸까?
- [X] System.lineSeparator() 알아보기
- [X] 클래스명이 Log인 것은 좋지 않다.
- [X] stream은 한줄에 하나씩 쓰는게 좋다.
- [X] 데이터베이스에 getter가 필요한가?
- [X] 차후 select가 생기면 어떻게 찾을 수 있을까?
- [ ] 단순히 콘솔 프로그램인데 서비스가 필요하다고 생각이 드는가?
- [X] test에 Mockito를 사용한 이유.

### 2차 피드백
- [X] build.gradle 관리
  - java version 관리
  - 사용하지 않는 라이브러리 제거
- [X] 람다 활용하기
- [X] 함수형 인터페이스 활용하기
- [X] Service 없애기
- [X] Error 출력을 outputView에서 출력
- [X] 정적 메서드를 사용한 이유?
- [X] 불변 및 멀티스레드에 생각
- [X] 문자열 상수로 바꾸기
- [X] 모든 메서드 1depth로 리팩토링