# java_calculator
자바 계산기 구현 미션 Repository입니다.

### 과제를 통해 기대하는 역량

- 깃허브를 통한 코드리뷰를 경험해보자
- 기본적인 테스트 코드 작성 및 활용하는 능력해보자
- 스스로 OOP를 생각하고 코드로 옮길 수 있는 능력해보자

### 요구사항
- 콘솔로 구현입니다.(스윙으로 구현하시는 분들 계실까봐) 
- 객체지향적인 코드로 계산기 구현하기
    - [x]  더하기
    - [x]  빼기
    - [x]  곱하기
    - [x]  나누기
    - [x]  우선순위(사칙연산)
- [ ]  테스트 코드 구현하기
- [x]  계산 이력을 맵으로 데이터 저장기능 만들기
    - 애플리케이션이 동작하는 동안 데이터베이스 외에 데이터를 저장할 수 있는 방법을 고안해보세요.
- (선택) 정규식 사용

### 구현 내용
- Main
  - Calculator,Records,View 클래스 생성, Console을 생성해 실행
- View
  - 기본 콘솔 내용 출력
  - 수행해야 할 작업 및 식 입력
  - 계산 결과 / 기록을 출력
- SelectViewType
  - 수행해야할 작업 목록
- Console
  - View에서 받은 선택에 따라 작업 실행
  - 전체 프로세스를 담당
- Records
  - 계산 결과를 저장 및 출력
- Calculator
  - CalculatorType에서 우선순위를 조회, 후위표기식으로 변경
  - CalculatorType에 연산을 위임
- CalculatorType
  - 연산자 정보 목록
  - 실제 연산을 수행

### ✍️ 수정 필요한 사항
- Input,Output을 인터페이스로 만들고 View가 상속받도록 했는데, 이러한 형태의 구조가 계산기에 적합한 설계인지 생각해볼 필요가 있음
  
<img width="1412" alt="스크린샷 2023-06-15 오후 5 20 38" src="https://github.com/HandmadeCloud/java-calculator-1/assets/77893164/548eaf30-d666-4bed-80db-9a1ef1546ecf">

