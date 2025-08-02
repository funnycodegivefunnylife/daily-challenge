package leetcode.challenge.leetcode_3443;

class Solution {
    public int maxDistance(String s, int k) {

        int west = 0, east = 0, north = 0, south = 0;
        int maxDistance = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'W' -> west++;
                case 'E' -> east++;
                case 'N' -> north++;
                case 'S' -> south++;
            }

            int modificationTimesForVertical = Math.min(Math.min(north, south), k);
            int modificationTimesForHorizontal = Math.min(Math.min(west, east), k - modificationTimesForVertical);

            int verticalDistance = calculateDistance(north, south, modificationTimesForVertical);
            int horizontalDistance = calculateDistance(west, east, modificationTimesForHorizontal);

            int totalDistance = verticalDistance + horizontalDistance;

            maxDistance = Math.max(maxDistance, totalDistance);
        }

        return maxDistance;
    }

    public int calculateDistance(int direction1, int direction2, int modificationTimes) {
        return Math.abs(direction1 - direction2) + modificationTimes * 2;
    }
}
