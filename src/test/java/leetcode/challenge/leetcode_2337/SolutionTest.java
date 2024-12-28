package leetcode.challenge.leetcode_2337;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {

        String start = "_L__R__R_";
        String target = "L______RR";

        assert solution.canChange(start, target);
    }


    @Test
    public void test2() {

        String start = "_L__R__R_";
        String target = "L______RR";

        assert solution.canChange(start, target);
    }



    @Test
    public void test3() {

        String start = "_L__R__R_L";
        String target = "L______RR_";

        assert !solution.canChange(start, target);
    }
}