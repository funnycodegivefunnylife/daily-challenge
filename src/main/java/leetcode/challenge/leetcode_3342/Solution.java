package leetcode.challenge.leetcode_3342;


import java.util.Comparator;
import java.util.PriorityQueue;

class Room {
    int x;
    int y;
    int time;
    int minToMove;

    Room(int x, int y, int time, int minToMove) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.minToMove = minToMove;
    }
}

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int shortestTime[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                shortestTime[i][j] = Integer.MAX_VALUE;
            }
        }

        shortestTime[0][0] = moveTime[0][0];

        PriorityQueue<Room> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));

        int[][] visited = new int[n][m];

        pq.add(new Room(0, 0, 0, 1));

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            Room currentRoom = pq.poll();

            if (currentRoom.x == n - 1 && currentRoom.y == m - 1) {
                return currentRoom.time;
            }

            if (visited[currentRoom.x][currentRoom.y] > 0) {
                continue;
            }
            visited[currentRoom.x][currentRoom.y] = 1;

            for (int[] dir : dirs) {
                int newX = currentRoom.x + dir[0];
                int newY = currentRoom.y + dir[1];

                if (newX >= 0 && newX < n && newY >=0 && newY < m) {
                    int newTime = Math.max(currentRoom.time, moveTime[newX][newY]) + currentRoom.minToMove;

                    if (newTime < shortestTime[newX][newY]) {
                        shortestTime[newX][newY] = newTime;
                        pq.add(new Room(newX, newY, newTime, currentRoom.minToMove == 1 ? 2: 1));
                    }

                }
            }

        }
        return -1;
    }
}