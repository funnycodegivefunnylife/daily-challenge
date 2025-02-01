package leetcode.challenge.leetcode_211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public WordDictionary() {}

    public void addWord(String word) {
        char[] charArray = word.toCharArray();
        Node node = root;

        for (char c : charArray) {
            node = node.addChildren(c);
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word);
    }

    public boolean dfs(Node node, String word) {
        if (node == null || word == null) {
            return false;
        }

        if (word.isBlank()) {
            return node.isEnd;
        }

        char firstChar = word.charAt(0);

        List<Node> children = new ArrayList<>();

        if (firstChar == '.') {
            children = Arrays.asList(node.children);
        } else {
            children = Arrays.asList(node.children[firstChar - 'a']);
        }
        String toFind = word.substring(1);
        for (Node child : children) {
            if (dfs(child, toFind)) {
                return true;
            }
        }

        return false;
    }
}
