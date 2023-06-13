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

<hr/>
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

<hr/>
## ✅ 피드백 반영사항  <!-- 지난 코드리뷰에서 고친 사항을 적어주세요. 재PR 시에만 사용해 주세요! (재PR 아닌 경우 삭제) -->

<hr/>
## ✅ PR 포인트 & 궁금한 점 <!-- 리뷰어 분들이 집중적으로 보셨으면 하는 내용을 적어주세요 -->
1. 테스트 코드
    * 테스트 완료한 메소드의 결과를 테스트해야할 메소드의 인자로 주어도 되는지 궁금합니다.
2. OOP 생활체조
    * App 클래스에서 Calculator 클래스로 필요한 모든 클래스를 주입했습니다.
      * Calculator 생명주기와 다른 클래스들의 생명주기가 같다고 판단해서 설계했는데, OOP를 위반하는 방식인지 궁금합니다.
    * 기능별로 클래스를 잘 분리했는지 궁금합니다.