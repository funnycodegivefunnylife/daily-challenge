package leetcode.challenge.leetcode_432;

import java.util.HashSet;

public class Bucket {
    int count;
    HashSet<String> keys;
    Bucket prev;
    Bucket next;

    public Bucket(int cnt) {
        count = cnt;
        keys = new HashSet<>();
    }

    public int getCount() {
        return count;
    }

    public HashSet<String> getKeys() {
        return keys;
    }

    public Bucket getPrev() {
        return prev;
    }

    public Bucket getNext() {
        return next;
    }
}
