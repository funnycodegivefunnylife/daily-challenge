package leetcode.challenge.leetcode_792;

import java.util.HashSet;
import java.util.Set;

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    Set<Integer> keys = new HashSet<>();
    boolean isEnd = false;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(Integer key, String str) {
        char[] charArr = str.toCharArray();

        TrieNode node = root;

        for (char c : charArr) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.keys.add(key);
        node.isEnd = true;
    }

    public Set<Integer> find(String str) {
        char[] charArr = str.toCharArray();

        TrieNode node = root;

        for (char c : charArr) {
            if (node.children[c - 'a'] == null) {
                return new HashSet<>();
            }
            node = node.children[c - 'a'];
        }

        return node.isEnd ? node.keys : new HashSet<>();
    }
}

class Solution {

    public String generateStringFromBitMask(String s, int mask) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((mask & (1 << i)) != 0) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public int numMatchingSubseq(String s, String[] words) {
        Trie trie = new Trie();

        int index = 0;
        for (String word : words) {
            trie.insert(index++, word);
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < (1 << s.length()); i++) {
            String str = generateStringFromBitMask(s, i);
            result.addAll(trie.find(str));
        }

        return result.size();
    }
}
