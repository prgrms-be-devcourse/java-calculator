#### refactor : CalculationApplication 책임 분할 및 명확한 책임 부여

- `CalculationApplication`의 책임을 명확하게 부여. -> 실행의 책임만을 부여.
- `CalculatorController Class`를 만들어서 명확한 MVC 패턴 사용.
  - 예외 흐름은 `WAS -> Filter -> Servlet -> Interceptor -> Controller(Exception!) -> 반복`
  - 기본적으로 예외 흐름은 위 흐름으로 알고 있기 때문에, 해당 컨트롤러에서 예외 처리.
- `Menu Enum Class`를 만들어서 유지보수성 및 재사용성 향상
- `OutputView`에서 쓰이는 `Message`들을 사용하는 `Message  lass`를 만들어서 관리

#### refactor : 줄바꿈 및 클래스명, 변수명 명확한 명칭 부여

- `Calculator` 모델 클래스명  -> `HistoryModel` 클래스명으로 변경
- 클래스명에 들어간 `Calculation` 모두 `Calculator`로 변경 
- `operation` 메소드 혹은 변수명 `formula`로 변경
- 의미없는 개행(줄박꿈) 삭제

#### refactor : 예외 처리 수정

- 윗단에서 호출하는 컨트롤러에서 `try-catch`로 예외처리를 진행하였습니다.
  - 즉, 아랫단에선 `throw new ~`로 예외를 발생시키기만 하였습니다. 
  - 이유: 아랫단에서 일일이 예외를 처리하면 반복적인 코드 작성으로 인해 미작성 혹은 잘못된 예외 처리가 발생하여 자원 낭비라고 생각했습니다.
- 다음과 같은 예외 클래스를 만들었습니다.
  - DivisionByZeroException : 0으로 나누면 발생
  - WrongInputFormulaException : 잘못된 연산식이면 발생
  - WrongInputMenuException
  - WrongInputSymbolException : 잘못된 연산자면 발생

#### refactor : 싱글톤 구현 방식 변경

- Thread-safe로부터 안전하지 못한 싱글톤 구현 방식 변경
- Static Inner Class 를 활용해 Thead-safe 하면서 LAZY 하게 구현

#### refactor : Stack -> Deque 변경 및 Business 로직에서 View 역할 분리

- `Business` 로직에서 `calculate()` 메소드가 `View` 역할하고 있었어서 분리하였음.
- 성능을 위해 `Stack`보단 `Deque`를 사용해야하는 이유를 알게 되면서 변경.

#### refactor : 메소드 접근 제어 private -> public 변경 및 메소드 기능 분리 

- 추후 테스트 코드를 위해 메소드를 `private` 에서 `public` 으로 변경했습니다.
- 메소드를 분리하다보니 실제 로직이 실행되는 `CalculatorManager Class`를 만들게 되었습니다.
- `removeSpaces` : 연산식의 공백을 제거합니다.
- `isCorrectFormula` : 연산식이 사칙연산과 숫자로만 이루어져 있는 지 판단하는 유효성 검증합니다. 
- `calculate` : 실제 연산이 진행되는 메소드들을 호출합니다.
- `isSymbolAndNumber` : 해당 토큰 값이 연산자인지 숫자인지 판단 후 그에 맞는 로직을 수행합니다.
- `isCalculation(...)`
  - 파라미터가 있다면 : 현재 연산식에서 가장 우선 순위가 높은 연산자가 있다면 계산을 진행합니다.
  - 파라미터가 없다면 : 우선순위가 가장 낮았던, 마지막 연산을 진행 후 최종 결과값을 반환합니다. 