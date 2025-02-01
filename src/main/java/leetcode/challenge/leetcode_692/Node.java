package leetcode.challenge.leetcode_692;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Node {
    Node[] children = new Node[26];
    boolean isLast;
}

class Trie {
    Node root = new Node();
    Map<String, Integer> frequencyMap = new java.util.HashMap<>();

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.isLast = true;
        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
    }

    public List<String> topKFrequent(int k) {
        List<String> result = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(result, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA == freqB) {
                return a.compareTo(b);
            }
            return freqB - freqA;
        });
        return result.subList(0, k);
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.topKFrequent(k);
    }
}
