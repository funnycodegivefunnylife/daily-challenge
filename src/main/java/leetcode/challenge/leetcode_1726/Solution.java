    package leetcode.challenge.leetcode_1726;

    import java.util.HashMap;
    import java.util.Map;

    class Solution {
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            int res = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {

                    int product = nums[i] * nums[j];

                    res += map.getOrDefault(product, 0);

                    map.put(product, map.getOrDefault(product, 0) + 1);
                }
            }

            return res;
        }
    }