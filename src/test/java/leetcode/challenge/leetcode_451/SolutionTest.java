package leetcode.challenge.leetcode_451;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        String s = "tree";
        String expected = "eert";
        String actual = solution.frequencySort(s);
        assertEquals(expected, actual);
    }
}