package leetcode.challenge.leetcode_2512;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class StudentScore {
    int id;
    int score;

    public StudentScore(int id, int score) {
        this.id = id;
        this.score = score;
    }
}

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<Integer, Integer> feedbackScore = new HashMap<>();

        for (String fb : positive_feedback) {
            feedbackScore.put(fb.hashCode(), 3);
        }

        for (String fb : negative_feedback) {
            feedbackScore.put(fb.hashCode(), -1);
        }

        PriorityQueue<StudentScore> pq = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) {
                return a.id - b.id;
            }
            return b.score - a.score;
        });

        for (int i = 0; i < report.length; i++) {
            int score = 0;
            for (String fb : report[i].split(" ")) {
                score += feedbackScore.getOrDefault(fb.hashCode(), 0);
            }
            pq.add(new StudentScore(student_id[i], score));
        }


        List<Integer> result = new java.util.ArrayList<>();

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result.add(pq.poll().id);
        }

        return result;
    }
}