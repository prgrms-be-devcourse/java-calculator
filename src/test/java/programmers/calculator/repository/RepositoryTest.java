package programmers.calculator.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RepositoryTest {

  Repository<String, String> repository;

  @BeforeEach
  void setUp() {
    repository = new InMemoryRepository();
  }

  @Test
  @DisplayName("메모리에 단일 값을 저장한다")
  void saveOne() {
    repository.save("key", "value");

    assertEquals(1, repository.findAll().size());
  }

  @Test
  @DisplayName("메모리에 동일한 값을 저장하면 기록은 두 개 나온다")
  void saveSame() {
    repository.save("key", "value");
    repository.save("key", "value");

    assertEquals(2, repository.findAll().size());
  }


  @Test
  @DisplayName("저장된 모든 값을 불러온다")
  void findAll() {
    repository.save("key1", "value1");
    repository.save("123 + 456", "789");
    repository.save("1 - 2", "-1");

    assertThat(repository.findAll()).containsExactly("key1 = value1", "123 + 456 = 789", "1 - 2 = -1");
  }

  @Test
  @DisplayName("저장된 값을 찾는다")
  void findExist() {
    repository.save("key", "value");

    assertNotNull(repository.find("key"));
    assertTrue(repository.find("key").isPresent());
    assertEquals("value", repository.find("key").get());
  }

  @Test
  @DisplayName("저장되지 않은 값을 찾으면 Optional.empty()을 반환한다")
  void findNotExist() {
    repository.save("key", "value");

    assertFalse(repository.find("notExistKey").isPresent());
  }
}