package leetcode.challenge.leetcode_677;

import java.util.Map;

class Node {
    Node[] children = new Node[26];
    int value = 0;
}

class MapSum {
    Node root = new Node();
    Map<String, Integer> map = new java.util.HashMap<>();

    public MapSum() {}

    public void insert(String key, int val) {
        Node node = root;
        int bonus = val - map.getOrDefault(key, 0);
        for (char c : key.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
            node.value += bonus;
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.value;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
