package test;

import org.junit.After;
import org.junit.Test;
import src.log.Log;
import src.log.LogRepository;
import src.log.MemoryLogRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LogRepositoryTest {

    private final LogRepository logRepository = new MemoryLogRepository();

    @After
    public void tearDown() throws Exception {
        logRepository.clear();
    }

    @Test
    public void save(){
        //given
        Log log = Log.createLog("1 + 2", "3");

        //when
        logRepository.save(log);

        //then
        List<Log> result = logRepository.findAll();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(log);
    }

    @Test
    public void findAll(){
        //given
        Log log1 = Log.createLog("1 + 2", "3");
        Log log2 = Log.createLog("1 + 2", "3");
        logRepository.save(log1);
        logRepository.save(log2);

        //when
        List<Log> result = logRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).isEqualTo(log1);
        assertThat(result.get(1)).isEqualTo(log2);
    }

}