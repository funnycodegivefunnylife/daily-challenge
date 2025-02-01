package leetcode.challenge.leetcode_1462;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean[][] isReachable = new boolean[numCourses][numCourses];

        for (int[] prerequisite : prerequisites) {
            isReachable[prerequisite[0]][prerequisite[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isReachable[i][k] && isReachable[k][j]) {
                        isReachable[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            result.add(isReachable[query[0]][query[1]]);
        }

        return result;
    }
}
