package leetcode.challenge.leetcode_1233;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LeetCode Problem 1233
 */
class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        //folder =
        //["/a","/a/b","/c/d","/c/d/e","/c/f"]
        String[] input = new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> expected = Arrays.asList("/a","/c/d","/c/f");

        List<String> actual = solution.removeSubfolders(input);

        assertLinesMatch(actual, expected);
    }
}
