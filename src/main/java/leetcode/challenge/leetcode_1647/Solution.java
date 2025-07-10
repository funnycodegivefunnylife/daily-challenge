    package leetcode.challenge.leetcode_1647;

    import java.util.*;


    class Solution {
        public int minDeletions(String s) {

            int[] freq = buildFrequencyArray(s);

            Map<Integer, Integer> freqCount = new HashMap<>();
            for (int f : freq) {
                if (f > 0) {
                    freqCount.put(f, freqCount.getOrDefault(f, -1) + 1);
                }
            }

            List<Integer> freqNeedToDelete = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
                int f = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < count; i++) {
                    freqNeedToDelete.add(f);
                }
            }

            // sort the frequencies in descending order
            freqNeedToDelete.sort(Collections.reverseOrder());

            int deletions = 0;


            //freqCount
            Set<Integer> seen = new HashSet<>();

            seen.addAll(freqCount.keySet());


    
            for (int f : freqNeedToDelete) {
                while (f > 0 && seen.contains(f)) {
                    f--;
                    deletions++;
                }
                if (f > 0) {
                    seen.add(f);
                }
            }

            return deletions;
        }

        public int[] buildFrequencyArray(String s) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            return freq;
        }
    }