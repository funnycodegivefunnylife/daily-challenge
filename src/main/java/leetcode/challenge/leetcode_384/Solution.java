package leetcode.challenge.leetcode_384;

class Solution {
    private int[] nums;

    private int[] original;
    public Solution(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        int[] shuffled = nums.clone();
        for (int i = 0; i < shuffled.length; i++) {
            int randomIndex = (int) (Math.random() * shuffled.length);
            int temp = shuffled[i];
            shuffled[i] = shuffled[randomIndex];
            shuffled[randomIndex] = temp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */