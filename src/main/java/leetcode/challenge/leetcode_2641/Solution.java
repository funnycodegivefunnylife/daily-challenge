package leetcode.challenge.leetcode_2641;

import java.util.Map;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class NodeWithLevel {
    TreeNode node;
    int level;
    NodeWithLevel(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> levelSum = new java.util.HashMap<>();

        Queue<NodeWithLevel> queue = new java.util.LinkedList<>();
        queue.add(new NodeWithLevel(root, 0));

        while (!queue.isEmpty()) {
            NodeWithLevel nodeWithLevel = queue.poll();
            TreeNode node = nodeWithLevel.node;
            int level = nodeWithLevel.level;
            levelSum.put(level, levelSum.getOrDefault(level, 0) + node.val);
            if (node.left != null) {
                queue.add(new NodeWithLevel(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new NodeWithLevel(node.right, level + 1));
            }
        }

        queue.add(new NodeWithLevel(root, 0));
        root.val = 0;

        while (!queue.isEmpty()) {
            NodeWithLevel nodeWithLevel = queue.poll();
            TreeNode node = nodeWithLevel.node;
            int level = nodeWithLevel.level;

            TreeNode left = node.left;
            TreeNode right = node.right;

            int leftAndRightSum = (left != null ? left.val : 0) + (right != null ? right.val : 0);
            int totalSum = levelSum.getOrDefault(level, 0);

            if (left != null) {
                left.val = totalSum - leftAndRightSum;
                queue.add(new NodeWithLevel(left, level + 1));
            }

            if (right != null) {
                right.val = totalSum - leftAndRightSum;
                queue.add(new NodeWithLevel(right, level + 1));
            }
        }

        return root;
    }
}