package leetcode.challenge.leetcode_1865;

import java.util.Map;

class FindSumPairs {

    private Map<Integer, Integer> nums1Map;
    private Map<Integer, Integer> nums2Map;
    private int[] nums1;
    private int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.nums1Map = new java.util.HashMap<>();
        this.nums2Map = new java.util.HashMap<>();

        nums1Map = initializeMap(nums1);
        nums2Map = initializeMap(nums2);

    }

    private Map<Integer, Integer> initializeMap(int[] nums) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    public void add(int index, int val) {
        if (index < 0 || index >= nums2.length) {
            throw new IndexOutOfBoundsException("Index out of bounds for nums2");
        }

        int oldValue = nums2[index];
        nums2[index] += val;

        // Update the maps
        nums2Map.put(oldValue, nums2Map.get(oldValue) - 1);
        if (nums2Map.get(oldValue) == 0) {
            nums2Map.remove(oldValue);
        }

        nums2Map.put(nums2[index], nums2Map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : nums1Map.entrySet()) {
            int num1 = entry.getKey();
            int num1Count = entry.getValue();

            // Calculate the required number in nums2 to form the sum
            int requiredNum2 = tot - num1;

            if (nums2Map.containsKey(requiredNum2)) {
                count += num1Count * nums2Map.get(requiredNum2);
            }
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */


class Solution {

}
