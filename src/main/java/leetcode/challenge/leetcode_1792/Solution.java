    package leetcode.challenge.leetcode_1792;


    import java.util.PriorityQueue;

    class ClassReport {
        int pass;
        int total;
        double average;
    }


    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {

            PriorityQueue<ClassReport> pq = new PriorityQueue<>((a, b) -> {
                double diffA = (a.pass + 1) * 1.0 / (a.total + 1) - a.pass * 1.0 / a.total;
                double diffB = (b.pass + 1) * 1.0 / (b.total + 1) - b.pass * 1.0 / b.total;
                return Double.compare(diffB, diffA);
            });

            for (int[] c : classes) {
                ClassReport cr = new ClassReport();
                cr.pass = c[0];
                cr.total = c[1];
                cr.average = (double) cr.pass / cr.total;
                pq.add(cr);
            }

            while (extraStudents > 0 && !pq.isEmpty()) {
                ClassReport cr = pq.poll();
                cr.pass++;
                cr.total++;
                cr.average = (double) cr.pass / cr.total;
                pq.add(cr);
                extraStudents--;
            }

            double sum = 0;

            while (!pq.isEmpty()) {
                ClassReport cr = pq.poll();
                sum += cr.average;
            }

            return sum / classes.length;
        }
    }