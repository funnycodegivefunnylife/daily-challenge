package leetcode.challenge.leetcode_501;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        Map<Integer, Integer> valueToFrequency = new HashMap<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            valueToFrequency.put(node.val, valueToFrequency.getOrDefault(node.val, 0) + 1);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int maxFrequency = 0;

        for (int frequency : valueToFrequency.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        for (Map.Entry<Integer, Integer> entry : valueToFrequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        return modes.stream().mapToInt(i -> i).toArray();
    }
}
