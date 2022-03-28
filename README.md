# java_calculator
자바 계산기 구현 미션 Repository입니다.

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

## 📌 과제 설명 <!-- 어떤 걸 만들었는지 대략적으로 설명해주세요 -->
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
## 👩‍💻 요구 사항과 구현 내용 <!-- 기능을 Commit 별로 잘개 쪼개고, Commit 별로 설명해주세요 -->
![Screen Shot 2022-03-28 at 12 42 15 PM](https://user-images.githubusercontent.com/58693617/160322765-4c946874-901e-4028-a023-dc80578dfd42.png)
Input,InputImpl -> 입력 담당 메소드
Output, OutputImpl -> 출력 담당 메소드
Operator -> 사칙연산 담당 Enum
Option -> 옵션 담당 Enum
CalculatorRepository, CalculatorRepositoryImpl -> DB 저장(LinkedHashMap)
ServiceImpl -> 계산기 동작을 담당하는 메소드
CalculatorService,CalculatorServiceImpl ->  계산 및 조회를 담당
Validator, ValidatorImpl -> 검증 인터페이스 및 구현체

## 테스트 케이스
![Screen Shot 2022-03-28 at 12 45 29 PM](https://user-images.githubusercontent.com/58693617/160323030-df128c24-b1f8-43a0-8d47-b82b72abd2a7.png)

## 예외 처리 내역
ArithmeticException -> 0으로 나눌때 발생
EmptyStackException -> 숫자, 연산의 비율이 맞지 않을때
IllegalArgumentException -> 사칙연산이 연속해서 입력됐을때,사칙연산이 아닌 문자가 입력됐을때
NoSuchElementException -> 메뉴 옵션 중 1,2,3이 아닌 수를 입력했을때
NumberFormatException -> 1,2,3이 아닌 문자를 입력했을때

## 계산기 시연
![Screen Shot 2022-03-28 at 13 27 43 PM](https://user-images.githubusercontent.com/58693617/160326663-38f40071-2050-47b6-a999-a93ec221e1c7.png)

## ✅ 피드백 반영사항  <!-- 지난 코드리뷰에서 고친 사항을 적어주세요. 재PR 시에만 사용해 주세요! (재PR 아닌 경우 삭제) -->

## ✅ PR 포인트 & 궁금한 점 <!-- 리뷰어 분들이 집중적으로 보셨으면 하는 내용을 적어주세요 -->
1. 테스트를 진행하면서 몇몇 중복된 테스트가 있었는데 이런 경우는 어쩔 수 없는 부분인지 궁금합니다.
2. ServiceImpl에서 run 메소드의 테스트 방법이 궁금합니다.
3. 현재 EmptyStackException이라는 예외가 있는데 메시지를 넣으려면 커스텀 클래스를 따로 만들어 넣어야 했습니다. 그러다 보니 하나의 예외처리를 위해 여러 메소드에 throws Exception이 추가되어 지저분한 느낌이었습니다. EmptyStack같이 예외를 특정할 수 있다면 굳이 메시지를 커스텀 안해도 될까요?
