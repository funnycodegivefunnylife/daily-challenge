package leetcode.challenge.leetcode_451;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

interface FrequencySort {
    String frequencySort(String s);
}

class Bucket {
    int frequency;
    Set<Character> characters = new HashSet<>();
}


class HashMapFrequencySort implements FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // sort by frequency
        Bucket[] buckets = new Bucket[s.length() + 1];

        for (char c : map.keySet()) {
            int frequency = map.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new Bucket();
            }
            buckets[frequency].characters.add(c);
            buckets[frequency].frequency = frequency;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i].characters) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}

class Solution {
    static FrequencySort frequencySort = new HashMapFrequencySort();
    public String frequencySort(String s) {

        return frequencySort.frequencySort(s);
    }
}