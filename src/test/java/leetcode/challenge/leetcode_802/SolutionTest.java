package leetcode.challenge.leetcode_802;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void eventualSafeNodes() {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> result = solution.eventualSafeNodes(graph);
        List<Integer> expected = List.of(2,4,5,6);

        assert result.size() == expected.size();
        for (int i = 0; i < result.size(); i++) {
            assert expected.contains(result.get(i));
        }
    }
}