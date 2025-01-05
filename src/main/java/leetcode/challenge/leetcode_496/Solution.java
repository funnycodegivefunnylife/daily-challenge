package leetcode.challenge.leetcode_496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int nextGreater[] = new int[nums2.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        
        int rs[] = new int[nums1.length];
        int it = 0;
        for (int num: nums1) {
            int index = map.get(num);
            rs[it++] = nextGreater[index];
        }

        return rs;

    }
}