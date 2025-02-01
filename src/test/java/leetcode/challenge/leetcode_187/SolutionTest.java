package leetcode.challenge.leetcode_187;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // "CAAAAAAAAAC"
    //
    // Use Testcase
    // Output
    // ["CAAAAAAAAA"]
    // Expected
    // []

    @org.junit.jupiter.api.Test
    void test1() {
        String s = "CAAAAAAAAAC";
        java.util.List<String> expected = java.util.Arrays.asList("CAAAAAAAAA");
        java.util.List<String> actual = solution.findRepeatedDnaSequences(s);
        assertTrue(assertArrayStringEquals(expected, actual));
    }

    boolean assertArrayStringEquals(java.util.List<String> expected, java.util.List<String> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                return false;
            }
        }
        return true;
    }
}
