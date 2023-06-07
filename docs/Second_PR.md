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

