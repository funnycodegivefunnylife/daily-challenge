package leetcode.challenge.leetcode_1980;

class BinaryTrieNode {
    BinaryTrieNode[] children = new BinaryTrieNode[2];
    boolean isLeaf;
}

class BinaryTrie {
    BinaryTrieNode root = new BinaryTrieNode();

    void insert(String s) {
        BinaryTrieNode node = root;
        for (char c : s.toCharArray()) {
            int index = c - '0';
            if (node.children[index] == null) {
                node.children[index] = new BinaryTrieNode();
            }
            node = node.children[index];
        }
        node.isLeaf = true;
    }

    String findMissing(int size) {
        BinaryTrieNode node = root;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < size) {
            if (node.children[0] != null && node.children[1] != null) {
                sb.append('0');
                node = node.children[0];
            } else if (node.children[0] == null) {
                sb.append('0');
                break;
            } else if (node.children[1] == null) {
                sb.append('1');
                break;
            }
        }

        while (sb.length() < size) {
            sb.append('0');
        }

        return sb.toString();
    }
}

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        BinaryTrie trie = new BinaryTrie();
        for (String num : nums) {
            trie.insert(num);
        }
        return trie.findMissing(nums.length);
    }
}
