package leetcode.challenge.leetcode_220;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

interface DuplicateChecker {
    boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff);
}

class SlidingWindowDuplicateChecker implements DuplicateChecker {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        int start = 0;

        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        set.add(nums[0]);
        map.put(nums[0], 1);

        for (int end = 1; end < nums.length; end++) {
            while (end - start > indexDiff) {
                int num = nums[start++];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    set.remove(num);
                }
            }

            int num = nums[end];

            if (set.ceiling(num) != null && set.ceiling(num) <= num + valueDiff) {
                return true;
            }

            if (set.floor(num) != null && set.floor(num) >= num - valueDiff) {
                return true;
            }

            set.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        return false;
    }
}


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        DuplicateChecker duplicateChecker = new SlidingWindowDuplicateChecker();
        return duplicateChecker.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
    }
}