package labs.demo.date_17_5_2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();

    @org.junit.jupiter.api.Test
    void countThreePalinDromes() {
        String s = "aaaabc";
        int result = main.countThreePalinDromes(s);
        int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void countThreePalinDromes2() {
        String s = "fknfkn";
        int result = main.countThreePalinDromes(s);
        int expected = 2;

        assertEquals(expected, result);
    }

}