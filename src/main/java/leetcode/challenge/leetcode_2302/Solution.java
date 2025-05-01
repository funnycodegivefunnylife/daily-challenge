package leetcode.challenge.leetcode_2302;

/** * This interface is used to check if an index is valid for the given condition.
 * It takes an index as input and returns a boolean indicating whether the
 * index satisfies the condition.
 */
@FunctionalInterface
interface ValidIndexChecker {
    boolean isValid(int index);
}

class Solution {

    /** * Counts the number of subarrays where the product of the sum and length
     * of the subarray is strictly less than k.
     *
     * @param nums The input array.
     * @param k The threshold value.
     * @return The count of valid subarrays.
     */
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        long totalCount = 0L;

        for (int right = 0; right < n; right++) {
            int finalRight = right;
            int left = findLeftmostValidIndex(right, index -> {
                long subarraySum = prefixSum[finalRight + 1] - prefixSum[index];
                int subarrayLength = finalRight - index + 1;
                return (subarraySum * subarrayLength) < k;
            });

            if (left != -1) {
                totalCount += (right - left + 1);
            }
        }

        return totalCount;
    }

    /** * Binary search to find the leftmost index that satisfies the condition.
     *
     * @param rightBound The right bound of the subarray.
     * @param validIndexChecker A functional interface to check if an index is valid.
     * @return The leftmost valid index or -1 if not found.
     */
    private int findLeftmostValidIndex(int rightBound, ValidIndexChecker validIndexChecker) {
        int low = 0;
        int high = rightBound;
        int validIndex = -1;

        while (low <= high) {
            int mid = (int) Math.ceil((low + high) / 2.0);

            if (validIndexChecker.isValid(mid)) {
                validIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return validIndex;
    }
}
