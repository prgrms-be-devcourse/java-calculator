import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ViewerTest {
    Viewer viewer = new Viewer();

    @Test
    @DisplayName("안내 메시지를 출력")
    void printInfoMessageTest() {
        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        viewer.printInfoMessage();
        // then
        assertThat(out.toString()).isEqualTo(
                """
                        1. 조회
                        2. 계산

                        선택 :\s"""
        );
    }
}
