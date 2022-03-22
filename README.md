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
    - [ ] 메뉴 입력
    - [ ] 계산식 입력
  - 출력
    - [ ] 메뉴 출력
    - [ ] 계산 결과 출력
    - [ ] 조회 결과 출력
- 핵심기능 
  - 사칙연산
    - [ ] 덧셈
    - [ ] 뺄셈
    - [ ] 나눗셈
    - [ ] 곱셈
    - [ ] 사칙연산(우선순위)
  - [ ] 계산 이력을 맵으로 데이터 저장 기능

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
