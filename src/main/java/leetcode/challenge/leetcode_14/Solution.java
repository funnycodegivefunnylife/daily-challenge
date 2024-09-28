package leetcode.challenge.leetcode_14;


class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    int count;
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++;

        }
        node.isEndOfWord = true;
    }

    public boolean verifyFrequency(String prefix, int target) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.count == target;
    }
}


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        assert strs.length > 0;
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }

        int resultIndex = 0;

        for (int i = 0; i < strs[0].length(); i++) {
            String prefix = strs[0].substring(0, i + 1);
            if (trie.verifyFrequency(prefix, strs.length)) {
                resultIndex = i + 1;
            } else {
                break;
            }
        }

        return strs[0].substring(0, resultIndex);
    }
}