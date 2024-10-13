package leetcode.challenge.leetcode_208;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    //["Trie","insert","search","search","startsWith","insert","search"]
    //[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]

    @Test
    void test1() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }
}