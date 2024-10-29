package leetcode.challenge.leetcode_2458;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeQueryTest {

    @Test
    void test1() {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(2), new TreeNode(6, null, new TreeNode(7))), new TreeNode(4, new TreeNode(5), null));
        int[] queries = {4};
        TreeQuery treeQuery = new TreeQuery();
        int[] result = treeQuery.treeQueries(root, queries);
        assertArrayEquals(new int[]{2}, result);
    }
}