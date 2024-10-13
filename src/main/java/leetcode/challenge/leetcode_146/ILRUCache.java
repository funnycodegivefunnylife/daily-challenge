package leetcode.challenge.leetcode_146;

public interface ILRUCache {
    int get(int key);
    void put(int key, int value);

    boolean isFull();
}
