package leetcode.challenge.leetcode_1997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode Problem 1997
 *
 * TODO: Add problem description and link
 * Link: https://leetcode.com/problems/
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        Map<Integer, Integer> numberOfVisitsOnRoom = new HashMap<>();

        Set<Integer> toVisit = new HashSet<>();
        for (int i = 0; i < nextVisit.length; i++) {
            numberOfVisitsOnRoom.put(i, 0);
            toVisit.add(i);
        }
        int start = 0;
        int day = -1;

        while (!toVisit.isEmpty()) {
            day++;
            numberOfVisitsOnRoom.put(start, numberOfVisitsOnRoom.get(start) + 1);
            toVisit.remove(start);
            int numberOfVisits = numberOfVisitsOnRoom.get(start);
            int nextVisitRoom = (start + 1) % nextVisit.length;
            if (numberOfVisits % 2 != 0) {
                nextVisitRoom = nextVisit[start];
            }
            start = nextVisitRoom;
        }

        return day;
    }
}
