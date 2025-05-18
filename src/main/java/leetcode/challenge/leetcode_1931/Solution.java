package leetcode.challenge.leetcode_1931;


import java.util.*;

class Solution {

    // The result is very large, so we need to take modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;
    // The maximum number of colors we can use, they are represented by 0, 1, and 2
    private static final int MAX_COLOR = 3;

    /**
     * This method calculates the number of ways to color a grid with m rows and n columns
     * using 3 colors, such that no two adjacent cells(neither horizontally nor vertically) have the same color.
     * Applied dynamic programming and state compression to solve the problem.
     * @param m The number of rows in the grid
     * @param n The number of columns in the grid
     * @return The number of ways to color the grid
     */
    public int colorTheGrid(int m, int n) {
        int maxState = (int) Math.pow(MAX_COLOR, m);

        Set<Integer> validStates = new HashSet<>();
        int[] dpCount = new int[maxState + 1];

        for (int state = 1; state <= maxState; state++) {
            if (validState(state, m)) {
                validStates.add(state);
                dpCount[state] = 1;
            }
        }

        Map<Integer, List<Integer>> validTransitions = new HashMap<>();

        for (int state1 : validStates) {
            for (int state2 : validStates) {
                if (validTransition(state1, state2, m)) {
                    validTransitions.computeIfAbsent(state1, k -> new ArrayList<>()).add(state2);
                }
            }
        }


        for (int colums = 1; colums < n; colums++) {
            int[] newDpCount = new int[maxState];
            for (int state : validStates) {
                for (int nextState : validTransitions.getOrDefault(state, Collections.emptyList())) {
                    newDpCount[state] = (newDpCount[state] + dpCount[nextState]) % MOD;
                }
            }
            dpCount = newDpCount;
        }

        int result = 0;

        for (int count : dpCount) {
            result = (result + count) % MOD;
        }

        return result;
    }

    /**
     * Check if the transition between two states is valid.
     * A transition is valid if no two values in the same index of the two states are the same.
     *
     * @param state1 The first state
     * @param state2 The second state
     * @param stateLength The length of the state
     * @return true if the transition is valid, false otherwise
     */
    public boolean validTransition(int state1, int state2, int stateLength) {

        for (int i = 0; i < stateLength; i++) {

            if (state1 % 3 == state2 % MAX_COLOR) {
                return false;
            }
            state1 /= MAX_COLOR;
            state2 /= MAX_COLOR;
        }
        return true;
    }

    /**
     * Check if the state is valid.
     * A state is valid if no two adjacent indices have the same value.
     *
     * @param state The state to check
     * @param stateLength The length of the state
     * @return true if the state is valid, false otherwise
     */
    public boolean validState(int state, int stateLength) {
        int lastColor = -1;

        for (int i = 0; i < stateLength; i++) {
           int currentColor = state % MAX_COLOR;
            if (currentColor == lastColor) {
                return false;
            }
            lastColor = currentColor;
            state /= MAX_COLOR;
        }

        return true;
    }
}