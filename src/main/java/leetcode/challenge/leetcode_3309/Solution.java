package leetcode.challenge.leetcode_3309;

class Solution {
    public int maxGoodNumber(int[] nums) {
        String first = Integer.toBinaryString(nums[0]);
        String second = Integer.toBinaryString(nums[1]);
        String third = Integer.toBinaryString(nums[2]);

        int firstSecondThird = fromBinaryString(first + second + third);
        int firstThirdSecond = fromBinaryString(first + third + second);
        int secondFirstThird = fromBinaryString(second + first + third);
        int secondThirdFirst = fromBinaryString(second + third + first);
        int thirdFirstSecond = fromBinaryString(third + first + second);
        int thirdSecondFirst = fromBinaryString(third + second + first);

        int max = Math.max(
                firstSecondThird,
                Math.max(
                        firstThirdSecond,
                        Math.max(
                                secondFirstThird,
                                Math.max(secondThirdFirst, Math.max(thirdFirstSecond, thirdSecondFirst)))));
        return max;
    }

    public int fromBinaryString(String s) {
        return Integer.parseInt(s, 2);
    }

    public String toBinaryString(int n) {
        return Integer.toBinaryString(n);
    }
}
