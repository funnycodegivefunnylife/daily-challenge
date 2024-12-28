package leetcode.challenge.leetcode_515;

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

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> levelMax = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();

        if (root != null) {
            queue.add(new Pair(root, 0));
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            if (levelMax.containsKey(level)) {
                levelMax.put(level, Math.max(levelMax.get(level), node.val));
            } else {
                levelMax.put(level, node.val);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, level + 1));
            }
        }

        for (int i = 0; i < levelMax.size(); i++) {
            result.add(levelMax.get(i));
        }

        return result;
    }
}