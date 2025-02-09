package leetcode.challenge.leetcode_2092;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    // Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
    // Output: [0,1,2,3,5]
    // Explanation:

    @Test
    void findAllPeople_1() {
        int n = 6;
        int[][] meetings = {{1, 2, 5}, {2, 3, 8}, {1, 5, 10}};
        int firstPerson = 1;
        int[] result = solution.findAllPeople(n, meetings, firstPerson).stream()
                .mapToInt(i -> i)
                .toArray();
        assertArrayEquals(new int[] {0, 1, 2, 3, 5}, result);
    }

    // n =
    // 5
    // meetings =
    // [[1,4,3],[0,4,3]]
    // firstPerson =
    // 3
    //
    // Use Testcase
    // Output
    // [0,3,4]
    // Expected
    // [0,1,3,4]

    @Test
    void findAllPeople_2() {
        int n = 5;
        int[][] meetings = {{1, 4, 3}, {0, 4, 3}};
        int firstPerson = 3;
        int[] result = solution.findAllPeople(n, meetings, firstPerson).stream()
                .mapToInt(i -> i)
                .toArray();
        assertArrayEquals(new int[] {0, 1, 3, 4}, result);
    }

    // [[3,1,3],[1,2,2],[0,3,3]]
    // firstPerson =
    // 3

    @Test
    void findAllPeople_3() {
        int n = 4;
        int[][] meetings = {{3, 1, 3}, {1, 2, 2}, {0, 3, 3}};
        int firstPerson = 3;
        int[] result = solution.findAllPeople(n, meetings, firstPerson).stream()
                .mapToInt(i -> i)
                .toArray();
        assertArrayEquals(new int[] {0, 1, 2, 3}, result);
    }

    // [[10,8,6],[9,5,11],[0,5,18],[4,5,13],[11,6,17],[0,11,10],[10,11,7],[5,8,3],[7,6,16],[3,6,10],[3,11,1],[8,3,2],[5,0,7],[3,8,20],[11,0,20],[8,3,4],[1,9,4],[10,7,11],[8,10,18]]

    @Test
    void findAllPeople_4() {
        int n = 12;
        int[][] meetings = {
            {10, 8, 6},
            {9, 5, 11},
            {0, 5, 18},
            {4, 5, 13},
            {11, 6, 17},
            {0, 11, 10},
            {10, 11, 7},
            {5, 8, 3},
            {7, 6, 16},
            {3, 6, 10},
            {3, 11, 1},
            {8, 3, 2},
            {5, 0, 7},
            {3, 8, 20},
            {11, 0, 20},
            {8, 3, 4},
            {1, 9, 4},
            {10, 7, 11},
            {8, 10, 18}
        };
        int firstPerson = 9;
        int[] result = solution.findAllPeople(n, meetings, firstPerson).stream()
                .mapToInt(i -> i)
                .toArray();
        assertArrayEquals(new int[] {0, 1, 4, 5, 6, 9, 11}, result);
    }
}
