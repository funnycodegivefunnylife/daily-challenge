package leetcode.challenge.leetcode_2161;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int numberOfSmaller = 0;
        int numberOfEqual = 0;

        for (int num : nums) {
            if (num < pivot) {
                numberOfSmaller++;
            } else if (num == pivot) {
                numberOfEqual++;
            }
        }

        int[] result = new int[nums.length];

        int startIndexOfEqual = numberOfSmaller;
        int startIndexOfLarger = numberOfSmaller + numberOfEqual;
        int startIndexOfSmaller = 0;

        for (int num : nums) {
            if (num < pivot) {
                result[startIndexOfSmaller++] = num;
            } else if (num == pivot) {
                result[startIndexOfEqual++] = num;
            } else {
                result[startIndexOfLarger++] = num;
            }
        }

        return result;
    }
}
