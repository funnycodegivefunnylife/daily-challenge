package leetcode.challenge.leetcode_996;


import java.util.*;

class MathUtil {
    public static boolean isSquareful(int a, int b) {
        int sum = a + b;
        int sqrt = (int) Math.sqrt(sum);
        return sqrt * sqrt == sum;
    }
}

class Node {
    int index;
    int value;
    int bitmask;
    String path;
    List<Node> adjacents = new ArrayList<>();

    public Node(int index, int value, int bitmask, String path) {
        this.index = index;
        this.value = value;
        this.bitmask = bitmask;
        this.path = path;
    }

    public boolean allVisited(int n) {
        return Integer.bitCount(bitmask) == n;
    }

    public boolean contains(int index) {
        return (bitmask & (1 << index)) > 0;
    }
}


class Solution {
    public int numSquarefulPerms(int[] nums) {
        return 1;
    }
}