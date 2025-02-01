package leetcode.challenge.leetcode_2601;

class Solution {

    static int[] isPrimes = new int[1001];

    static {
        isPrimes[2] = 1;
        for (int i = 3; i <= 1000; i++) {
            if (isPrime(i)) {
                isPrimes[i] = 1;
            }
        }
    }

    public static boolean isPrime(int n) {

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int findPrime(int prev, int num) {

        int result = -1;
        for (int i = num - 1; i >= 2; i--) {
            if (isPrimes[i] == 1 && num - i > prev) {
                result = i;
                break;
            }
        }

        return result;
    }

    public boolean primeSubOperation(int[] nums) {

        int prev = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int next = findPrime(prev, num);

            if (next != -1) {
                prev = num - next;
                nums[i] = prev;
            } else {
                prev = num;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
