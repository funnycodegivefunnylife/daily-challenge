package leetcode.challenge.leetcode_2779;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

class Solution {
    public int maximumBeauty(int[] nums, int k) {

        Arrays.sort(nums);


        int max = 1;
        int start = 0;


        for (int end = 1; end < nums.length; end++) {
            while (start < end && nums[end] - nums[start] > 2 * k) {
                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }

}