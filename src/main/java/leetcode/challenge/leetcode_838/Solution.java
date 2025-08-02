package leetcode.challenge.leetcode_838;

class Solution {
    public String pushDominoes(String dominoes) {

        int left = 0;
        int right = 0;

        char[] arr = dominoes.toCharArray();

        while (left < dominoes.length()) {
            if (arr[left] == '.') {
                while (right < arr.length && arr[right] == '.') {
                    right++;
                }

                if (right < arr.length) {
                    arr[left++] = arr[right];
                } else {
                    break;
                }
            } else {
                left++;
                right = left + 1;
            }
        }

        return new String(arr);
    }
}
