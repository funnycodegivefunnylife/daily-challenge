package leetcode.challenge.leetcode_460;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {


    @Test
    void test1() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);

        int expected = 1;
        int actual = lfuCache.get(1);
        assertEquals(expected, actual);

        lfuCache.put(3, 3);

        expected = -1;
        actual = lfuCache.get(2);
        assertEquals(expected, actual);

        expected = 3;
        actual = lfuCache.get(3);
        assertEquals(expected, actual);

        lfuCache.put(4, 4);
        expected = -1;
        actual = lfuCache.get(1);
        assertEquals(expected, actual);
        expected = 3;
        actual = lfuCache.get(3);
        assertEquals(expected, actual);
        expected = 4;
        actual = lfuCache.get(4);
        assertEquals(expected, actual);
    }

    //["LFUCache","get","put","get","put","put","get","get"]
    //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    //[null,-1,null,-1,null,null,2,6]
    @Test
    void test2() {
        LFUCache lfuCache = new LFUCache(2);
        int expected = -1;
        int actual = lfuCache.get(2);
        assertEquals(expected, actual);

        lfuCache.put(2, 6);
        expected = -1;
        actual = lfuCache.get(1);
        assertEquals(expected, actual);

        lfuCache.put(1, 5);
        lfuCache.put(1, 2);
        expected = 2;
        actual = lfuCache.get(1);
        assertEquals(expected, actual);

        expected = 6;
        actual = lfuCache.get(2);
        assertEquals(expected, actual);
    }

    //["LFUCache","put","get","put","get","put","get"]
    //[[2],[1,1],[1],[2,2],[2],[3,3],[2]]

    @Test
    void test3() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        int expected = 1;
        int actual = lfuCache.get(1);
        assertEquals(expected, actual);

        lfuCache.put(2, 2);
        expected = 2;
        actual = lfuCache.get(2);
        assertEquals(expected, actual);

        lfuCache.put(3, 3);
        expected = -1;
        actual = lfuCache.get(2);
        assertEquals(expected, actual);
    }
}