package leetcode.challenge.leetcode_3174;

import java.util.LinkedList;
import java.util.Queue;

enum State {
    ALPHABET,
    DIGIT,
    DELETE,
}

class Solution {
    public String clearDigits(String s) {
        Queue<Integer> digitIndices = new LinkedList<>();
        State[] states = new State[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digitIndices.add(i);
                states[i] = State.DIGIT;
            } else {
                states[i] = State.ALPHABET;
            }
        }

        while (digitIndices.size() > 0) {
            int index = digitIndices.poll();
            states[index] = State.DELETE;
            int nearestAlphaIndexOnLeft = findNearestAlphaIndexOnLeft(states, index);
            if (nearestAlphaIndexOnLeft != -1) {
                states[nearestAlphaIndexOnLeft] = State.DELETE;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (states[i] != State.DELETE) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    private int findNearestAlphaIndexOnLeft(State[] states, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (states[i] == State.ALPHABET) {
                return i;
            }
        }
        return -1;
    }
}
