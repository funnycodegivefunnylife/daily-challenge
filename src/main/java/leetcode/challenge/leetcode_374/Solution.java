package leetcode.challenge.leetcode_374;

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
abstract class GuessGame {
    int guess(int num) {
        return 0;
    }

    public abstract int guessNumber(int n);
}

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
