package leetcode.challenge.leetcode_2701;

import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 1;
        int right = Math.min(tasks.length, workers.length);
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCompleteFirstKTasks(tasks, workers, pills, strength, mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    boolean canCompleteFirstKTasks(int[] tasks, int[] workers, int pills, int strength, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = workers.length - k; i < workers.length; i++) {
            map.put(workers[i], map.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = k - 1; i >= 0; i--) {
            int task = tasks[i];
            Integer worker = map.lastKey();

            if (worker >= task) {
                map.put(worker, map.get(worker) - 1);
                if (map.get(worker) == 0) {
                    map.remove(worker);
                }
            } else if (pills > 0) {
                Integer pillWorker = map.ceilingKey(task - strength);
                if (pillWorker != null) {
                    pills--;
                    map.put(pillWorker, map.get(pillWorker) - 1);
                    if (map.get(pillWorker) == 0) {
                        map.remove(pillWorker);
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
