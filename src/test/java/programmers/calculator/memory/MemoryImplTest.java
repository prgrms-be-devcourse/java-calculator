package programmers.calculator.memory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MemoryImplTest {

  Memory<String, String> memory;

  @BeforeEach
  void setUp() {
    memory = new MemoryImpl();
  }

  @Test
  @DisplayName("메모리에 단일 값을 저장한다")
  void saveOne() {
    memory.save("key", "value");

    assertEquals(1, memory.findAll().size());
  }

  @Test
  @DisplayName("메모리에 동일한 값을 저장하면 기록은 두 개 나온다")
  void saveSame() {
    memory.save("key", "value");
    memory.save("key", "value");

    assertEquals(2, memory.findAll().size());
  }


  @Test
  @DisplayName("저장된 모든 값을 불러온다")
  void findAll() {
    memory.save("key1", "value1");
    memory.save("123 + 456", "789");
    memory.save("1 - 2", "-1");

    assertThat(memory.findAll()).containsExactly("key1 = value1", "123 + 456 = 789", "1 - 2 = -1");
  }

  @Test
  @DisplayName("저장된 값을 찾는다")
  void findExist() {
    memory.save("key", "value");

    assertNotNull(memory.find("key"));
    assertTrue(memory.find("key").isPresent());
    assertEquals("value", memory.find("key").get());
  }

  @Test
  @DisplayName("저장되지 않은 값을 찾으면 Optional.empty()을 반환한다")
  void findNotExist() {
    memory.save("key", "value");

    assertFalse(memory.find("notExistKey").isPresent());
  }
}