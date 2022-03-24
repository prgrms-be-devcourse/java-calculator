package org.programmers.repository;

//import org.junit.jupiter.api.Assertions;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.programmers.entity.ResultModel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRepositoryTest {

    private Repository repository = new CalculatorRepository();

  //  @AfterEach
//    public void afterEach(){
//        repository();
//    }

    @Test
    void saveAndfindAllTest() {;

        repository.save("2 * 3", 6);
        repository.save("3 / 2", 1.5);
        repository.save("", 0);

        List<ResultModel> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(3);
    }


}