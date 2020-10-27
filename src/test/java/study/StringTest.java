package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }
    @Test
    void split2(){
        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }
    @Test
    void substring(){
        String result3 = "(1,2)";
        result3 = result3.substring(result3.indexOf("(")+1, result3.indexOf(")"));
    }
    @DisplayName("String charAt test")
    @Test
    void chatAt(){
        Throwable thrown = catchThrowable(() -> {
            char result4 = "abc".charAt(2);
        });
        assertThat(thrown)
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3");
    }
}
