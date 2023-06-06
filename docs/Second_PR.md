#### refactor : CalculationApplication 책임 분할 및 명확한 책임 부여

- CalculationApplication의 책임을 명확하게 부여. -> 실행의 책임만을 부여.
- CalculatorController Class를 만들어서 명확한 MVC 패턴 사용.
  - 예외 흐름은 WAS -> Filter -> Servlet -> Interceptor -> Controller(Exception!) -> 반복
  - 기본적으로 예외 흐름은 위 흐름으로 알고 있기 때문에, 해당 컨트롤러에서 예외 처리.
- Menu Enum Class를 만들어서 유지보수성 및 재사용성 향상
- OutputView에서 쓰이는 Message들을 사용하는 Message Class를 만들어서 관리