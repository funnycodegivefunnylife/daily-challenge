package leetcode.challenge.leetcode_212;

import leetcode.challenge.shared.ListUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordSearchTest {

    @Test
    void test1() {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String word = "oath";
        List<String> expected = List.of("oath");

        assert ListUtil.listEquals(WordSearch.INTERFACE.findWords(board, new String[]{word}), expected);
    }

    @Test
    void test2() {
        char[][] board = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String word = "abcb";
        List<String> expected = List.of();

        assert ListUtil.listEquals(WordSearch.INTERFACE.findWords(board, new String[]{word}), expected);
    }
}