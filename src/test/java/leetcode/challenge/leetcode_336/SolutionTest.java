package leetcode.challenge.leetcode_336;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // Input: words = ["abcd","dcba","lls","s","sssll"]
    // Output: [[0,1],[1,0],[3,2],[2,4]]
    @Test
    void test1() {
        String[] words = new String[] {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4));
        List<List<Integer>> actual = solution.palindromePairs(words);
        assertTwoDimensionalListEquals(expected, actual);
    }

    @Test
    void test2() {
        String[] words = new String[] {"bat", "tab", "cat"};
        List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0));
        List<List<Integer>> actual = solution.palindromePairs(words);
        assertTwoDimensionalListEquals(expected, actual);
    }

    @Test
    void test3() {
        String[] words = new String[] {"a", ""};
        List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0));
        List<List<Integer>> actual = solution.palindromePairs(words);
        assertTwoDimensionalListEquals(expected, actual);
    }

    public void assertTwoDimensionalListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            List<Integer> expectedList = expected.get(i);
            List<Integer> actualList = actual.get(i);
            assertEquals(expectedList.size(), actualList.size());
            for (int j = 0; j < expectedList.size(); j++) {
                assertEquals(expectedList.get(j), actualList.get(j));
            }
        }
    }

    public boolean isEqualPairs(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }

        for (int i = 0; i < expected.size(); i++) {
            List<Integer> expectedPair = expected.get(i);
            List<Integer> actualPair = actual.get(i);

            if (expectedPair.size() != actualPair.size()) {
                return false;
            }

            for (int j = 0; j < expectedPair.size(); j++) {
                if (expectedPair.get(j) != actualPair.get(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
