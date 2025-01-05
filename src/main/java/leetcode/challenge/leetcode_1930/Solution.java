package leetcode.challenge.leetcode_1930;

import java.util.*;

class IndexTrack {
    int start;
    int end;

    public IndexTrack(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {

    public int countPalindromicSubsequence(String s) {
        IndexTrack[] indexTracks = new IndexTrack[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (indexTracks[idx] == null) {
                indexTracks[idx] = new IndexTrack(i, i);
            } else {
                indexTracks[idx].end = i;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (indexTracks[i] == null) {
                continue;
            }

            count += countUniqueCharacters(s, indexTracks[i].start + 1, indexTracks[i].end - 1);
        }

        return count;
    }

    public int countUniqueCharacters(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}