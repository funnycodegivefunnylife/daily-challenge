package leetcode_146;

import leetcode.challenge.leetcode_146.ILRUCache;
import leetcode.challenge.leetcode_146.LRUCacheLinkedListImpl;

public class LRUCacheBuilder {
    public static ILRUCache build(int capacity) {
        return new LRUCacheLinkedListImpl(capacity);
    }
}
