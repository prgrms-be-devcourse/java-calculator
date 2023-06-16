<!--
  템플릿은 아직 PR 작성이 익숙하지 않으신 분들을 위해서 제공하는 가이드입니다!
  리뷰어 또는 이 PR을 보게 될 다른 사람들이 이 PR을 보는데 참고할 수 있는 내용이 있다면 포함해서 작성해주시면 됩니다.
-->

## 📌 과제 설명 <!-- 어떤 걸 만들었는지 대략적으로 설명해주세요 -->
* `Calculator` : 모든 작업 요청, 결과가 이뤄지는 클래스
* `Validator` : 검증 인터페이스
* `Converter` : 후위변환 인터페이스
* `Computer` : 계산 인터페이스
* `Historian`   : 계산 기록, 출력 클래스
* `Input` : 입력 인터페이스
* `Output` : 출력 인터페이스
* `Operator` : 연산자 관련 enum 클래스
* `InvalidInputException` : 표현식 검증 Exception 클래스

![diagram](https://github.com/prgrms-be-devcourse/java-calculator/assets/54990890/af5e8512-35ec-4953-88ec-517d6a28d03f)
![seq_diagram](https://github.com/prgrms-be-devcourse/java-calculator/assets/54990890/e03e82fe-1167-43a2-8a6e-90efcfb7501d)


## 👩‍💻 요구 사항과 구현 내용 <!-- 기능을 Commit 별로 잘개 쪼개고, Commit 별로 설명해주세요 -->
- #### 기능 구현
- [x] 검증
    - [x] 정규식
    - [x] 소수점 -> (?:) 패턴으로 부적절한 소수점 숫자 버림
- [x] 계산 -> BiFunction 을 갖는 enum 클래스(Operator)
    - [x] 더하기 -> Operator.PLUS
    - [x] 빼기 -> Operator.MINUS
    - [x] 곱하기 -> Operator.MULTIPLY
    - [x] 나누기 -> Operator.DIVIDE (0 나누기 예외처리)
- [x] 우선순위 (사칙연산)
    - [x] 괄호 -> Operator enum 클래스에 괄호 추가(우선순위 적용)
- [x] 이력 -> HashMap 활용
    - [x] 계산이력 저장
    - [x] 계산이력 조회 -> 조회할 기록이 없는 경우 예외처리

- #### 테스트
- [x] 계산 기능
    - [x] 검증
    - [x] 우선순위
    - [x] 계산결과
- [x] 이력 기능
    - [x] 이력 저장
    - [x] 이력 조회

## ✅ 피드백 반영사항  <!-- 지난 코드리뷰에서 고친 사항을 적어주세요. 재PR 시에만 사용해 주세요! (재PR 아닌 경우 삭제) -->

`계산에 들어갈 요소가 어떤게 있을지 생각하면서 적은게 좋았다.`
#### 구조
* io 패키지 제외 모두 model 패키지에 들어갈 수 있음.
* `Historian` -> `Histories`
* Input, Output도 불필요한 추상화 들어감.
* Computer, Converter를 interface로 분리한 이유가 없음.

#### 일반
* 컬렉션은 복수 표기가 일반적.
* `exp`같은 축약어 사용 지양하기
* 자바 컨벤션에서는 중괄호 생략하지 않음.

#### 구현
* `Calculator` 클래스에서 `label:` 구문 제거
    * 향상된 `switch` 문으로 `break` 키워드 제거
    * `case` 조건 String을 다시 `Menu enum` 클래스로 변환
* `Calculator` `run` 메소드에서 들여쓰기 조절
    * run에는 while 문만 두기
    * actual operate에 `try-catch` 블럭 두기
    * menu operate에서 향상 switch 문으로 유저 상호작용하기
* `validator`가 모호
    * 검증하는 객체인데 검증, 변환 둘 다 함
    * 검증만 수행하도록 분리
* `SimpleValidator` 클래스에 있는 필드 변수 책임
    * 생성자로 초기화해주던가
    * 초기화하는 기능을 validator 바깥에 따로 해주던가
* `SimpleComputer` `calculate` 메소드 사용부분 단순화
    * 변수로 빼는 방법
    * 메소드로 나누는 방법
* `Historian` 클래스에서 띄어쓰기, 수식 넣는걸 `output`으로 책임 넘기기
* 괄호는 operator인가?
* `Operator` 클래스 `getOperator` 메소드는 값을 못 찾을 때 NPE 발생 가능
    * get(0) 말고도, orelse로 예외처리?
    * Optional로 받을까?

#### 테스트
* 테스트 코드 given, when, then 형태로 나누기
* @ParameterizedTest 이용 -> 테스트 코드 중복 줄이기

## ✅ PR 포인트 & 궁금한 점 <!-- 리뷰어 분들이 집중적으로 보셨으면 하는 내용을 적어주세요 -->
1. 테스트 코드
    * 테스트 완료한 메소드의 결과를 테스트해야할 메소드의 인자로 주어도 되는지 궁금합니다.
2. OOP 생활체조
    * App 클래스에서 Calculator 클래스로 필요한 모든 클래스를 주입했습니다.
      * Calculator 생명주기와 다른 클래스들의 생명주기가 같다고 판단해서 설계했는데, OOP를 위반하는 방식인지 궁금합니다.
    * 기능별로 클래스를 잘 분리했는지 궁금합니다.


### Git Commit Convention
* feat : 기능
* fix  : 버그 수정
* docs : 문서 작업
* style: 포맷팅, ;추가
* refactor : 리팩토링 (기능 변경 X)
* test : 테스트 코드 추가
* chore : 유지 (빌드 작업, 패키지 메니저 작업)