package leetcode.challenge.leetcode_1942;

import java.util.*;

class TimeEvent {
    int time;
    int id;
    boolean isStart;

    TimeEvent(int time, int id, boolean isStart) {
        this.time = time;
        this.id = id;
        this.isStart = isStart;
    }
}

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

        List<TimeEvent> events = new ArrayList<>();

        for (int i = 0; i < times.length; i++) {
            events.add(new TimeEvent(times[i][0], i, true));
            events.add(new TimeEvent(times[i][1], i, false));
        }

        // compare by time and let leave event come first
        events.sort(
                (a, b) -> a.time == b.time ? Boolean.compare(a.isStart, b.isStart) : Integer.compare(a.time, b.time));

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i);
        }

        int[] sitOnChair = new int[times.length];

        for (TimeEvent event : events) {
            if (event.isStart) {
                int id = event.id;
                int chair = availableChairs.poll();
                sitOnChair[id] = chair;
                if (isTargetFriend(id, targetFriend)) {
                    return chair;
                }
            } else {
                availableChairs.add(sitOnChair[event.id]);
            }
        }
        return -1;
    }

    public boolean isTargetFriend(int id, int targetFriend) {
        return id == targetFriend;
    }
}
