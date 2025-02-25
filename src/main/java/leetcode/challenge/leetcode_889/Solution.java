package leetcode.challenge.leetcode_889;

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
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {


    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode buildTree(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int leftRootVal = pre[preStart + 1];
        int leftRootIndex = -1;
        for (int i = postStart; i < postEnd; i++) {
            if (post[i] == leftRootVal) {
                leftRootIndex = i;
                break;
            }
        }

        int leftSize = leftRootIndex - postStart + 1;
        root.left = buildTree(pre, post, preStart + 1, preStart + leftSize, postStart, leftRootIndex);
        root.right = buildTree(pre, post, preStart + leftSize + 1, preEnd, leftRootIndex + 1, postEnd - 1);

        return root;
    }
}