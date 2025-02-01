package leetcode.challenge.leetcode_460;

import java.util.HashMap;
import java.util.Map;

class Key {
    int key;
    int value;
    int frequency;
    Key prev;
    Key next;

    public Key(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}

class LFUCache {
    private int capacity;
    private Key head;
    private Key tail;
    Map<Integer, Key> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new Key(-1, -1, -1);
        tail = new Key(-1, -1, -1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Key keyToGet = cache.get(key);
            removeKey(keyToGet);
            increaseCount(keyToGet);
            cache.put(key, keyToGet);
            return keyToGet.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (isFull() && !cache.containsKey(key)) {
            removeLast();
        }

        Key keyToPut;

        if (cache.containsKey(key)) {
            keyToPut = cache.get(key);
            keyToPut.value = value;
            keyToPut.frequency++;
            removeKey(keyToPut);
        } else {
            keyToPut = new Key(key, value, 0);
        }

        cache.put(key, keyToPut);

        increaseCount(keyToPut);
    }

    private void increaseCount(Key key) {
        key.frequency++;
        Key cursonKey = tail;

        while (cursonKey.prev != head && cursonKey.prev.frequency <= key.frequency) {
            cursonKey = cursonKey.prev;
        }

        insertBefore(cursonKey, key);
    }

    public void insertBefore(Key onCursorKey, Key keyToPut) {
        Key prev = onCursorKey.prev;
        prev.next = keyToPut;
        keyToPut.prev = prev;
        keyToPut.next = onCursorKey;
        onCursorKey.prev = keyToPut;
    }

    public void removeKey(Key key) {
        Key prev = key.prev;
        Key next = key.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }

        cache.remove(key.key);
    }

    public void removeLast() {
        if (tail.prev != head) {
            Key keyToRemove = tail.prev;
            tail.prev = keyToRemove.prev;
            keyToRemove.prev.next = tail;
            cache.remove(keyToRemove.key);
        }
    }

    public boolean isFull() {
        return cache.size() == capacity;
    }
}
