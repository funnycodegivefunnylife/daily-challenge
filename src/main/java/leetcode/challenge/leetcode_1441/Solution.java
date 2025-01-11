package leetcode.challenge.leetcode_1441;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> buildArray(int[] target, int n) {

        Stack<Integer> stack = new Stack<>();

        List<String> rs = new ArrayList<>();

        int currentMatch = -1;
        int current = 1;

        while (currentMatch < target.length - 1 && current <= n) {

            if (current == target[currentMatch + 1]) {
                rs.add("Push");
                currentMatch++;
            } else {
                rs.add("Push");
                rs.add("Pop");
            }
            current++;
        }

        return rs;
    }


}