package leetcode.challenge.leetcode_1636;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> intToFreq = buildFrequencyMap(nums);

        int[] result = new int[nums.length];

        // loop through map
        List<Map.Entry<Integer, Integer>> entries = intToFreq.entrySet().stream()
                .sorted((a, b) -> compare(a.getValue(), b.getValue(), a.getKey(), b.getKey()))
                .toList();

        return fillResultArray(entries, result);
    }

    int[] fillResultArray(List<Map.Entry<Integer, Integer>> entries, int[] result) {
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : entries) {
            int freq = entry.getValue();
            int value = entry.getKey();

            for (int i = 0; i < freq; i++) {
                result[index++] = value;
            }
        }

        return result;
    }

    int compare(int freqA, int freqB, int A, int B) {
        if (freqA != freqB) {
            return Integer.compare(freqA, freqB);
        } else {
            return Integer.compare(B, A); // reverse order for same frequency
        }
    }

    Map<Integer, Integer> buildFrequencyMap(int[] nums) {
        Map<Integer, Integer> rs = new HashMap<>();

        for (int num : nums) {
            rs.put(num, rs.getOrDefault(num, 0) + 1);
        }

        return rs;
    }
}
