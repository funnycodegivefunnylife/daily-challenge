package leetcode.challenge.leetcode_2416;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    int prefixCount = 0; // To store how many words pass through this node
    Map<Character, TrieNode> child = new HashMap<>();
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.child.computeIfAbsent(c, k -> new TrieNode());
            node.prefixCount++;  // Increment prefix count at each node
        }
    }

    int countStartWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.child.get(c);
            if (node == null) {
                return 0;
            }
        }
        return node.prefixCount; // Return the prefix count from the node
    }
}

public class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        // Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }

        // Calculate the result array
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            TrieNode node = trie.root;
            int count = 0;
            // Traverse the Trie character by character for the word
            for (char c : words[i].toCharArray()) {
                node = node.child.get(c);
                count += node.prefixCount;
            }
            result[i] = count;
        }
        return result;
    }
}
