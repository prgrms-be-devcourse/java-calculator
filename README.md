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
- 정규식은 사용하지 않았니다.

### 처리 과정
![img.png](img.png)

### PR 포인트 & 궁금한 점

1. 연산자 하드코딩 제거
* 문자열을 파싱, 우선순위 확인, 계산 과정에서 연산자를 하드코딩으로 비교하는 것을 제거하고자 
* Util 클래스에 static 필드로 `<Character, Operator에 대한 Enum>` 형식으로 데이터를 초기화 해서 참조하도록 구현하였습니다.
* 이러한 경우 적용하면 더 효과적인 패턴? 전략? 이있을까요??
  
2. 코드에서 눈에 띄는 안좋은 습관이나, SOLID에 위배되는 경우, 개선 점에 대해 가감없이 조언주시면 달게받고 개선하겠습니다.


