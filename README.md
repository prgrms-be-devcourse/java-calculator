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

- CalculateService
    - 사용자의 입력을 전달받아 계산 및 저장.
    - 계산결과를 조회.

- Parser
    - 입력 문자열 유효성 검사.
    - 피연산자와 연산자를 스페이스 단위로 구분하여 새로운 문자열 반환

- Sorter
    - 연산자 우선순위, 인덱스 위치를 기준으로 정렬

- Calculate
    - 정렬 된 연산자를 기준으로 계산을 수행


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
