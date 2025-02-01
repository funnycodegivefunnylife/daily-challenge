package leetcode.challenge.leetcode_745;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEnd = false;
    public Set<Integer> indexes = new HashSet<>();

    public boolean searchKey(char c) {
        return children[c - 'a'] != null;
    }
}

class Trie {
    private TrieNode root = new TrieNode();

    public Trie() {}

    public void insert(int index, String word) {
        char[] chars = word.toCharArray();

        TrieNode node = root;

        for (char c : chars) {
            if (!node.searchKey(c)) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.indexes.add(index);
        }

        node.isEnd = true;
    }

    public Set<Integer> startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (!node.searchKey(c)) {
                return Collections.emptySet();
            } else {
                node = node.children[c - 'a'];
            }
        }

        return node.indexes;
    }
}

class WordFilter {
    Trie prefix = new Trie();
    Trie suffix = new Trie();

    public WordFilter(String[] words) {

        int index = 0;
        for (String word : words) {
            prefix.insert(index, word);
            suffix.insert(index, reverString(word));
            index++;
        }
    }

    public String reverString(String str) {
        byte[] bytes = str.getBytes();
        byte[] result = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[bytes.length - 1 - i];
        }

        return new String(result);
    }

    public int f(String pref, String suff) {
        Set<Integer> prefixResult = prefix.startsWith(pref);
        Set<Integer> suffixResult = suffix.startsWith(reverString(suff));
        List<Integer> intersect = findIntersect(prefixResult, suffixResult);

        return intersect.stream().max(Integer::compareTo).orElse(-1);
    }

    public List<Integer> findIntersect(Set<Integer> first, Set<Integer> second) {

        return first.stream().filter(second::contains).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // ["WordFilter","f"]
        // [[["apple"]],["a","e"]]

        WordFilter wordFilter = new WordFilter(new String[] {"apple"});
        wordFilter.f("a", "e");
    }
}
