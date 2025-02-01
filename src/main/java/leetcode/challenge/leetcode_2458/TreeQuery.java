package leetcode.challenge.leetcode_2458;

import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
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

class TreePath {
    TreeNode node;
    int height;
    int bitMask;

    TreePath(TreeNode node, int height, int bitMask) {
        this.node = node;
        this.height = height;
        this.bitMask = bitMask;
    }
}

public class TreeQuery {

    public int[] treeQueries(TreeNode root, int[] queries) {

        Queue<TreePath> queue = new java.util.LinkedList<>();
        queue.add(new TreePath(root, 0, 0));

        int[] result = new int[queries.length];

        while (!queue.isEmpty()) {
            TreePath treePath = queue.poll();
            TreeNode node = treePath.node;
            int height = treePath.height;
            int bitMask = treePath.bitMask;
            for (int i = 0; i < queries.length; i++) {
                if (queries[i] == node.val) {
                    bitMask |= 1 << (i + 1);
                }
            }

            for (int i = 0; i < queries.length; i++) {

                boolean contains = (bitMask & (1 << (i + 1))) != 0;
                if (!contains) {
                    result[i] = Math.max(result[i], height);
                }
            }

            if (node.left != null) {
                queue.add(new TreePath(node.left, treePath.height + 1, bitMask));
            }
            if (node.right != null) {
                queue.add(new TreePath(node.right, treePath.height + 1, bitMask));
            }
        }

        return result;
    }
}
