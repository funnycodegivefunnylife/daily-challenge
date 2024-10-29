package leetcode.challenge.leetcode_677;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapSumTest {
    //["MapSum","insert","sum","insert","insert","sum"]
    @Test
    void test1() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertEquals(3, mapSum.sum("ap"));
        mapSum.insert("app", 2);
        mapSum.insert("apple", 2);
        assertEquals(4, mapSum.sum("ap"));
    }
}