package leetcode.challenge.leetcode_1818;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[] {1, 7, 5};
        int[] nums2 = new int[] {2, 3, 5};
        int actual = solution.minAbsoluteSumDiff(nums, nums2);

        assertEquals(3, actual);
    }


    @Test
    public void test2() {
        int[] nums = new int[] {1, 3, 5};
        int target = 3;

        int actual = solution.findIndexClosest(nums, target);

        assertEquals(1, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] {1, 7, 15};
        int[] nums2 = new int[] {2, 6, 14};
        int actual = solution.minAbsoluteSumDiff(nums, nums2);

        assertEquals(3, actual);
    }


    @Test
    public void test4() {
        int[] nums = new int[] {1, 3, 4, 5, 6};
        int target = 4;

        int actual = solution.findIndexClosest(nums, target);

        assertEquals(2, actual);
    }

    @Test
    public void test5() {
        int[] nums = new int[] {53,48,14,71,31,55,6,80,28,19,15,40,7,21,69,15,5,42,86,15,11,54,44,62,9,100,2,26,81,87,87,18,45,29,46,100,20,87,49,86,14,74,74,52,52,60,8,25,21,96,7,90,91,42,32,34,55,20,66,36,64,67,44,51,4,46,25,57,84,23,10,84,99,33,51,28,59,88,50,41,59,69,59,65,78,50,78,50,39,91,44,78,90,83,55,5,74,96,77,46};
        int[] nums2 = new int[] {39,49,64,34,80,26,44,3,92,46,27,88,73,55,66,10,4,72,19,37,40,49,40,58,82,32,36,91,62,21,68,65,66,55,44,24,78,56,12,79,38,53,36,90,40,73,92,14,73,89,28,53,52,46,84,47,51,31,53,22,24,14,83,75,97,87,66,42,45,98,29,82,41,36,57,95,100,2,71,34,43,50,66,52,6,43,94,71,93,61,28,84,7,79,23,48,39,27,48,79};
        int actual = solution.minAbsoluteSumDiff(nums, nums2);

        assertEquals(3156, actual);
    }

    @Test
    public void test6() {
        int[] nums = new int[] {1, 3, 4, 5, 6};
        int target = 0;

        int actual = solution.findIndexClosest(nums, target);

        assertEquals(0, actual);
    }

    @Test
    public void test7() {
        int[] nums = new int[] {1, 3, 4, 5, 6};
        int target = 7;

        int actual = solution.findIndexClosest(nums, target);

        assertEquals(4, actual);
    }

    //public int findLastLte(int[] nums, int target) {

    @Test
    public void test8() {
        int[] nums = new int[] {1, 3, 4, 5, 6};
        int target = 0;

        int actual = solution.findLastLte(nums, target);

        assertEquals(-1, actual);
    }

    @Test
    public void test9() {
        int[] nums = new int[] {1,3};
        int target = 2;

        int actual = solution.findLastLte(nums, target);

        assertEquals(0, actual);
    }

}