
## 자바 계산기 구현 미션 기능목록 작성

동작 예시 
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

- [ ] 입력
  - [ ] Scanner를 통한 콘솔 입력 
  - [ ] BufferedReader로 입력 받는 것 교체 / 확장 가능 하게 추상화 시키기 (OCP)
  
- [ ] 조회 기능 구현
  - [ ] 계산 후 이력을 List로 저장 -> Repository에서 생성
    - [ ] repository 패키지 안 Listfmf 가진 일급 컬렉션으로 구현
    - [ ] 인터페이스로 repository 추상화
  - [ ] 조회 기능 선택 시 계산 이력을 List에서 가져 오기 (repository에서 controller로 직접적으로 가져오기)

- [ ] 계산 기능 구현
  - [ ] 덧셈
  - [ ] 뺄셈
  - [ ] 나눗셈
  - [ ] 곱하기
  - [ ] 우선순위 (사칙연산)
    - [ ] 후위 표기식 찾아보기 
    - [ ] 나눗셈과 곱셈이 덧셈과 뺄셈보다 우선순위가 높다
    - [ ] 식에서 

- [ ] 예외 처리
  - [ ] 조회(1), 계산(2) 이외의 값을 입력 했을 경우 `IllegalArgumentException` 발생
  - [ ] 형식 (숫자 + 공백 +  기호 + 공백 + 숫자 + 공백  + 기호 + ...)이 잘못된 경우 `IllegalArgumentException` 발생
  - [ ] int 자료형 overflow / underflow 발생 시 `ArithmeticException` 발생