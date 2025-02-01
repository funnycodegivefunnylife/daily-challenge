package leetcode.challenge.leetcode_621;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }

        int mostFrequentTask = 0;
        for (int i = 0; i < 26; i++) {
            if (taskCount[i] > taskCount[mostFrequentTask]) {
                mostFrequentTask = i;
            }
        }

        int maxTaskCount = taskCount[mostFrequentTask];

        int idleTime = (maxTaskCount - 1) * n;

        for (int i = 0; i < 26; i++) {
            if (i != mostFrequentTask) {
                idleTime -= Math.min(taskCount[i], maxTaskCount - 1);
            }
        }

        return Math.max(idleTime, 0) + tasks.length;
    }
}
