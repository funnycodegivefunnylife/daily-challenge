package leetcode.challenge.leetcode_648;

import java.util.List;
import java.util.Optional;


class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEnd = false;

    public boolean searchKey(char c) {
        return children[c - 'a'] != null;
    }
}

class Trie {
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

    public Optional<String> findShortestPrefix(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (!node.searchKey(c)) {
                return Optional.empty();
            } else {
                sb.append(c);
                node = node.children[c - 'a'];
                if (node.isEnd) {
                    return Optional.of(sb.toString());
                }
            }
        }

        return Optional.empty();
    }

}


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            Optional<String> prefix = trie.findShortestPrefix(word);
            if (prefix.isPresent()) {
                sb.append(prefix.get());
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}