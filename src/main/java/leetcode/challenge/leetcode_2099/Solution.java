package leetcode.challenge.leetcode_2099;

import java.util.Comparator;

class Element {
    int value;
    int index;

    Element(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {

    public int[] maxSubsequence(int[] nums, int k) {
        Element[] elements = new Element[nums.length];
        for (int i = 0; i < nums.length; i++) {
            elements[i] = new Element(nums[i], i);
        }

        // Sort elements based on their values in descending order
        java.util.Arrays.sort(elements, (a, b) -> Integer.compare(b.value, a.value));

        // Select the top k elements
        Element[] topKElements = new Element[k];
        for (int i = 0; i < k; i++) {
            topKElements[i] = elements[i];
        }

        // Sort the selected elements by their original indices
        java.util.Arrays.sort(topKElements, Comparator.comparingInt(a -> a.index));

        // Prepare the result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topKElements[i].value;
        }

        return result;
    }
}
