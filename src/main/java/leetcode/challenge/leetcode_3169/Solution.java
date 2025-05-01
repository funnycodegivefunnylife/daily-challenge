package leetcode.challenge.leetcode_3169;

import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // sort the meetings by start time then end time
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int lastMeeting = 0;
        int availableDays = 0;
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > lastMeeting) {
                availableDays += start - lastMeeting - 1;
            }

            lastMeeting = Math.max(lastMeeting, end);

            if (lastMeeting >= days) {
                break;
            }
        }

        availableDays += days - lastMeeting;

        return availableDays;
    }
}
