package hw;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Ex10 {

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", " ", "012345678912345", "qwertyuiopasdfgh"})
    public void testEx10(String string) {
        int expectedLength = 15;
        assertTrue(expectedLength <= string.length(), "String length is less than expected");
    }
}
