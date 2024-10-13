package leetcode.challenge.leetcode_208;

import java.util.List;

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEnd = false;

    public boolean searchKey(char c) {
        return children[c - 'a'] != null;
    }
}

public class Trie {
    private TrieNode root = new TrieNode();

    public Trie() {

    }

    public void insert(String word) {
        char[] chars = word.toCharArray();

        TrieNode node = root;

        for (char c : chars) {
            if (!node.searchKey(c)) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (!node.searchKey(c)) {
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }

        return node.isEnd;
    }


    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (!node.searchKey(c)) {
                return false;
            } else {
                node = node.children[c - 'a'];
            }
        }

        return true;
    }
}
