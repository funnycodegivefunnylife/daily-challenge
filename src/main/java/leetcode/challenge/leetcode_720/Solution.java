package leetcode.challenge.leetcode_720;

import java.util.*;

class Node {
    Node[] children = new Node[26];
    boolean isEnd;

    Node addChildren(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new Node();
        }

        return children[c - 'a'];
    }

    Optional<Node> getNode(char c) {
        return Optional.ofNullable(children[c - 'a']);
    }
}

class WordDictionary {
    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        char[] charArray = word.toCharArray();
        Node node = root;

        for (char c : charArray) {
            node = node.addChildren(c);
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Node node = root;

        for (char c : charArray) {
            Optional<Node> optionalNode = node.getNode(c);
            if (optionalNode.isEmpty()) {
                return false;
            }
            node = optionalNode.get();
        }

        return node.isEnd;
    }
}


class Solution {
    public String longestWord(String[] words) {
        WordDictionary wordDictionary = new WordDictionary();
        for (String word : words) {
            wordDictionary.addWord(word);
        }

        List<String> result = new java.util.ArrayList<>();
        int maxLen = 1;
        words = java.util.Arrays.stream(words).sorted().toArray(String[]::new);

        for (String word : words) {
            for (int i = word.length(); i > 0; i--) {
                if (!wordDictionary.search(word.substring(0, i))) {
                    break;
                }
                if (i == 1) {
                    result.add(word);
                    maxLen = Math.max(maxLen, word.length());
                }
            }
        }
        int maxLength = result.stream().max(Comparator.comparingInt(String::length)).orElse("").length();

        List<String> maxWords = new java.util.ArrayList<>();
        for (String word : result) {
            if (word.length() == maxLength) {
                maxWords.add(word);
            }
        }

        return maxWords.stream().min(String::compareTo).orElse("");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"w", "o"}));
    }

}