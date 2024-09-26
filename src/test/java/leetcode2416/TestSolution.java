package leetcode2416;

import leetcode.challenge.leetcode2416.Solution;
import org.junit.jupiter.api.Test;

public class TestSolution {
    private static final Solution solution = new Solution();


    @Test
    public void test1() {
        String[] words = {"abc","ab","bc","b"};
        int[] expected = {5,4,3,2};
        assert equal(solution.sumPrefixScores(words), expected);
    }

    public boolean equal(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test2() {
        String[] words = {"abcd"};
        int[] expected = {4};
        assert equal(solution.sumPrefixScores(words), expected);
    }
}
