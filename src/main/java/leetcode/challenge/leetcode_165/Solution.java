package leetcode.challenge.leetcode_165;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> parseVersion(String version) {
        List<Integer> rs = new ArrayList<>();

        String[] parts = version.split("\\.");

        for (String part : parts) {
            rs.add(Integer.parseInt(part));
        }

        return rs;
    }
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = parseVersion(version1);
        List<Integer> v2 = parseVersion(version2);

        int i = 0;
        while (i < v1.size() && i < v2.size()) {
            int a = v1.get(i);
            int b = v2.get(i);

            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }

            i++;
        }

        while (i < v1.size()) {
            if (v1.get(i) > 0) {
                return 1;
            }
            i++;
        }

        while (i < v2.size()) {
            if (v2.get(i) > 0) {
                return -1;
            }
            i++;
        }

        return 0;
    }
}