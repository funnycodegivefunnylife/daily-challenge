package leetcode.challenge.leetcode_212;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEnd = false;

    public boolean searchKey(char c) {
        return children[c - 'a'] != null;
    }
}

class Trie {
    public TrieNode root = new TrieNode();

    public Trie() {}

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

public class WordSearchTrieImpl implements WordSearch {

    private Trie buildFromWords(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

    private List<String> searchWords(char[][] board, TrieNode trie, int[][] visited, int i, int j, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == 1) {
            return List.of();
        }

        word += board[i][j];
        if (!trie.searchKey(board[i][j])) {
            return List.of();
        }

        visited[i][j] = 1;

        List<String> result = new ArrayList<>();

        if (trie.children[board[i][j] - 'a'].isEnd) {
            result.add(word);
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            result.addAll(searchWords(board, trie.children[board[i][j] - 'a'], visited, newI, newJ, word));
        }

        visited[i][j] = 0;

        return result;
    }

    @Override
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildFromWords(words);

        Set<String> result = new java.util.HashSet<>();

        List<List<Integer>> startPoints = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.startsWith(String.valueOf(board[i][j]))) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    startPoints.add(point);
                }
            }
        }

        for (List<Integer> point : startPoints) {
            int i = point.get(0);
            int j = point.get(1);
            int[][] visited = new int[board.length][board[0].length];
            List<String> wordsFound = searchWords(board, trie.root, visited, i, j, "");
            result.addAll(wordsFound);
        }

        return new ArrayList<>(result);
    }
}
