### 요구사항과 구현 내용
- 객체지향적인 코드로 계산기 구현하기
    - [x]  더하기
    - [x]  빼기
    - [x]  곱하기
    - [x]  나누기
    - [x]  우선순위(사칙연산)
- [x]  테스트 코드 구현하기
- [x]  계산 이력을 맵으로 데이터 저장기능 만들기
    - List로 저장
- 정규식은 사용하지 않았습니다.
- 괄호는 고려하지 않았습니다.

### 기능(Interface)

- Parser
    - 수식의 유효성을 검사 후 스페이스 1개 단위의 명령어를 반환 함.
    - 유효성 검사 실패의 경우 null 반환

- Sorter
    - 연산자 우선순위, 인덱스 위치를 기준으로 정렬

- Calculate
    - 올바른 수식에 대한 계산을 수행


### 실행 방법
``` bash
git clone https://github.com/Pawer0223/java-calculator.git;
cd java-calculator;

# mac
./gradlew build;
./graldew run;

# window
./gradlew.bat build;
./gradlew.bat run;
```

### 개선 사항
 
1. 명사 표현 DIVISION 변경
  - DIVIDE로 변경

2. 입력에 대한 if 분기 처리를 switch-case 변경(Calculator.java)

3. Parse.parsing 메소드 명 변경
  - validateAndRemake로 변경
      - 유효성 실패 시 null반환
      - 성공 시 스페이스 1개로 구분한 새로운 문자열 반환
  
4. 스프링의 색을 완전히 빼고 각 객체의 역할, 책임 만을 생각하여 다시 작성
  - AS-IS
    - 계산기(Calculator) 객체는 CalculationService에 의존하여 계산 및 조회 기능을 처리
      - `CalculationService.calculate(계산)`
      - `CalculationService.findAll(조회)`
        
    - 계산 서비스 객체(Calculate)에서 정렬 후 계산.
      - 계산 서비스 객체(Calculate)는 Sorter를 의존
        
    - Dto 사용

  - TO-BE
    - 계산기(Calculator) 객체는 계산, 파싱, 정렬에 대한 기능을 주입받아 처리
        - CalculationService를 제거
        
    - 계산 서비스 객체(Calculate)가 계산 기능만을 처리하도록 변경
        - sort는 계산기 객체(Calculator)에서 호출 됨
    
    - Service, ServiceImpl 디렉터리를 제거
        - engine 하위에 기능 클래스 별도 관리(calculate, parser, sorter)
    
    - Dto 제거