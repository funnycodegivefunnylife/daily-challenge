package leetcode.challenge.leetcode_2375;

class Solution {
    public String smallestNumber(String pattern) {
        boolean[] used = new boolean[10];

        return generate(pattern, 0, used);
    }

    public String generate(String pattern, int index, boolean[] used) {
        if (index == pattern.length()) {
            return "";
        }

        char c = pattern.charAt(index);
        if (c == 'I') {
            for (int i = 0; i < 10; i++) {
                if (!used[i]) {
                    used[i] = true;
                    String result = generate(pattern, index + 1, used);
                    if (result != null) {
                        return i + result;
                    }
                    used[i] = false;
                }
            }
        } else {
            for (int i = 9; i >= 0; i--) {
                if (!used[i]) {
                    used[i] = true;
                    String result = generate(pattern, index + 1, used);
                    if (result != null) {
                        return i + result;
                    }
                    used[i] = false;
                }
            }
        }

        return null;
    }
}
