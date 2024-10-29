package leetcode.challenge.leetcode_212;

import java.util.List;

public interface WordSearch {
    WordSearch INTERFACE = new WordSearchTrieImpl();

    List<String> findWords(char[][] board, String[] words);
}
