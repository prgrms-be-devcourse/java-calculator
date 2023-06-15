## 📌 과제 설명

- [x] 콘솔로 구현
- [x] OOP 계산기 구현
    - [x] 더하기
    - [x] 빼기
    - [x] 곱하기
    - [x] 나누기
    - [x] 우선순위 (사칙연산)
- [ ] 테스트 코드 구현
- [x] 계산 이력을 맵으로 데이터 저장 기능
    - 애플리케이션이 동작하는 동안 DB 외에 데이터를 저장할 수 있는 방법 고민
- [x] 정규식 사용

<br>

## 👩‍💻 요구 사항과 구현 내용

1. 입력과 출력이 현재는 콘솔이지만, 각기 다른 형태로 바뀔 수 있어서 인터페이스로 추상화하고 이를 구현한 InputConsole과 OutputConsole이 생겼습니다.
2. Calculator 클래스에서 입력을 받게 했다가 계산이라는 책임에서 멀어지는 것 같아서 Controller를 추가하여 연결시켰습니다.
3. Enum 클래스를 활용하여 선택 가능한 메뉴를 정의하였고 예외처리를 진행했습니다.
4. Calculator 클래스에서는 계산이라는 동작만 수행하고 Expression이라는 표현식 클래스에서 표현식과 관련된 모든 책임을 갖습니다.
    - 연산자에 대한 책임은 Enum 클래스를 활용한 Operator에서 가지고 있습니다.
5. 저장소를 구현할 때, HistoryRepository로 추상화하였고 이를 구현했습니다. 추가로, CalculationHistory 객체를 이용하여 저장시키도록 구현했습니다.
6. 기존에 정규식을 다루던 곳은 Expression 이었으나, 수식 계산마다 Pattern을 생성하는 비용이 크다고 생각하여, 따로 util로 뺐습니다.
    - Pattern 생성 비용에 관한 근거는, 클래스를 살펴보면 `new Pattern()` 하는 부분입니다.

<br>

## ✅ 구현 예정

- 테스트코드 작성이 미흡하여, 1차 자기주도적 리뷰 이후 구현 예정입니다.

<br>

## ✅ PR 포인트 & 궁금한 점

- Expression 클래스의 기능이 너무 비대해진 점이 고민입니다.
- 객체 간 책임 분리에 관하여 사실 감이 잘 잡히지 않습니다.

<br>

## 😭 1차 자기주도적 리뷰 피드백

**영수님 피드백**
1. 값의 검증에는 예외처리를 하지 않는 것이 좋습니다. (`Expression` 클래스의 `isNumber()` 메서드)
2. `Calculator` 클래스에서 필드로 `expression`을 가지는 것에 의문이 듭니다.
3. `Expression` 클래스가 너무 비대하고 특히 `converToPostfix()` 메서드를 최대한 쪼개봅시다.
4. `if-else` 보단 `switch`를 이용하여 리팩토링 해봅시다.
5. 최대한 3 depth를 넘지 않게 메서드를 리팩토링 해봅시다.
6. 여러 객체가 참조하는 형태가 아니라면, static 사용에 관하여 고민해봅시다.
    - OutOfMemory에 관해서도 고려해봅시다.
    - 가능한 static을 사용하지 않고 코드를 짜봅시다.
7. Regex는 상수를 모아놓기 위한 장소같아보이는데, 어떤 고민을 해봐야할까요? 생각해봅시다.

<br>

**흑구님 피드백**
1. 현재 모두 구현인 것 같고, 확장에 너무 닫혀 있습니다.
2. 궁금한 것을 설명하고 싶은 의도는 알겠으나, 코드리뷰 요청하는 입장에서 코드를 주석처리한 것은 반드시 없애봅시다.
3. 인스턴스를 생성하지 못하게 하고 싶을 때, 방어적으로 코드 작성하는 것을 생각합시다.
4. 1개의 콘솔로 입출력 하는 상황인데, `InputConsole`과 `OutputConsole`이 마치 2개의 콘솔처럼 보입니다.
5. 객체지향적 설계가 어렵다면, 저만의 방식인데, logic → behavior → data 를 생각해봅시다.
    - logic : data를 이용한 behavior의 전체적인 흐름
    - behavior : data를 이용하는 어떠한 행위
    - data : 말 그대로 데이터, 객체
    - logic은 behavior에, behavior은 data에 의존(사용)
    - 각각 interaction(상호작용)에 관해서도 생각해볼 것
6. 무조건 메서드로 표현할 필요는 없습니다. 객체간 상호작용이 부족한 지 생각해봅시다.
7. 무조건 적인 set 지양은 하지말고, 어떤 문제가 있는지, 어떤 이유 때문인지 알고 set을 지양해봅시다. 너무 무서워하지 마세요.