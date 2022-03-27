package test;

import org.junit.After;
import org.junit.Test;
import src.log.Log;
import src.log.LogDB;
import src.log.MemoryLogDB;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LogDBTest {

    private final LogDB logDB = new MemoryLogDB();

    @After
    public void tearDown() throws Exception {
        logDB.clear();
    }

    @Test
    public void save(){
        //given
        Log log = Log.createLog("1 + 2", "3");

        //when
        logDB.save(log);

        //then
        List<Log> result = logDB.findAll();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(log);
    }

    @Test
    public void findAll(){
        //given
        Log log1 = Log.createLog("1 + 2", "3");
        Log log2 = Log.createLog("1 + 2", "3");
        logDB.save(log1);
        logDB.save(log2);

        //when
        List<Log> result = logDB.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).isEqualTo(log1);
        assertThat(result.get(1)).isEqualTo(log2);
    }

}