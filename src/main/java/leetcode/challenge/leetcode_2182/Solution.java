package leetcode.challenge.leetcode_2182;

import java.util.PriorityQueue;

class CharacterCount {
    char c;
    int count;

    public CharacterCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] charArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        CharacterCount[] characterCounts = new CharacterCount[26];

        for (char c : charArray) {
            int index = c - 'a';
            if (characterCounts[index] == null) {
                characterCounts[index] = new CharacterCount(c, 1);
            } else {
                characterCounts[index].count++;
            }
        }

        PriorityQueue<CharacterCount> pq = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (CharacterCount cc : characterCounts) {
            if (cc != null) {
                pq.add(cc);
            }
        }

        while (!pq.isEmpty()) {
            CharacterCount cc = pq.poll();
            for (int i = 0; i < cc.count && i < repeatLimit; i++) {
                sb.append(cc.c);
            }
        }

        return sb.toString();
    }
}