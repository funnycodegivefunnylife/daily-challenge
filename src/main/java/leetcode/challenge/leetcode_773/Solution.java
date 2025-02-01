package leetcode.challenge.leetcode_773;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class NodeState {
    String state;
    int zeroX;
    int zeroY;
    int steps;

    public NodeState(int[][] board, int zeroX, int zeroY, int steps) {
        this.state = "";
        this.zeroX = zeroX;
        this.zeroY = zeroY;
        this.steps = steps;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        this.state = sb.toString();
    }

    public NodeState(char[] stateInCharArray, int zeroX, int zeroY, int steps) {
        this.state = new String(stateInCharArray);
        this.zeroX = zeroX;
        this.zeroY = zeroY;
        this.steps = steps;
    }

    public boolean canMove(int stepX, int stepY) {
        int newX = zeroX + stepX;
        int newY = zeroY + stepY;

        return newX >= 0 && newX < 2 && newY >= 0 && newY < 3;
    }

    public NodeState move(int stepX, int stepY) {
        if (!canMove(stepX, stepY)) {
            throw new IllegalArgumentException("Cannot move");
        }
        int newX = zeroX + stepX;
        int newY = zeroY + stepY;

        char[] chars = state.toCharArray();

        char temp = chars[zeroX * 3 + zeroY];
        chars[zeroX * 3 + zeroY] = chars[newX * 3 + newY];
        chars[newX * 3 + newY] = temp;

        return new NodeState(chars, newX, newY, steps);
    }

    public boolean reachedTarget(String target) {
        return state.equals(target);
    }
}

class Solution {
    public int slidingPuzzle(int[][] board) {

        int startZeroX = 0;
        int startZeroY = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    startZeroX = i;
                    startZeroY = j;
                }
            }
        }

        NodeState start = new NodeState(board, startZeroX, startZeroY, 0);

        int[][] nextMoves = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<NodeState> queue = new LinkedList<>();

        queue.add(start);

        String target = "123450";

        Map<String, Integer> visited = new java.util.HashMap<>();

        while (!queue.isEmpty()) {
            NodeState current = queue.poll();

            if (current.reachedTarget(target)) {
                return current.steps;
            }

            for (int[] move : nextMoves) {
                if (current.canMove(move[0], move[1])) {
                    NodeState next = current.move(move[0], move[1]);
                    if (!visited.containsKey(next.state)) {
                        visited.put(next.state, 1);
                        queue.add(next);
                    }
                }
            }
        }

        return -1;
    }
}
