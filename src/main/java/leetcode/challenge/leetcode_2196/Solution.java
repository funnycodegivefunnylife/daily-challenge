package leetcode.challenge.leetcode_2196;

import java.util.Map;

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

class Description {
    int parent;
    int child;
    boolean isLeft;

    Description(int parent, int child, boolean isLeft) {
        this.parent = parent;
        this.child = child;
        this.isLeft = isLeft;
    }

    static Description fromArray(int[] description) {
        int parent = description[0];
        int child = description[1];
        boolean isLeft = description[2] == 1;
        return new Description(parent, child, isLeft);
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new java.util.HashMap<>();

        Description[] descs = new Description[descriptions.length];
        for (int i = 0; i < descriptions.length; i++) {
            descs[i] = Description.fromArray(descriptions[i]);
        }

        Map<Integer, Integer> childToParent = new java.util.HashMap<>();

        for (Description desc : descs) {
            int parentVal = desc.parent;
            int childVal = desc.child;
            boolean isLeft = desc.isLeft;

            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            nodeMap.put(parentVal, parentNode);
            nodeMap.put(childVal, childNode);
            childToParent.put(childVal, parentVal);
        }

        TreeNode root = null;

        for (int key : nodeMap.keySet()) {
            if (!childToParent.containsKey(key)) {
                root = nodeMap.get(key);
                break;
            }
        }

        if (root == null) {
            throw new IllegalArgumentException("No root found in the descriptions.");
        }

        return root;
    }
}
