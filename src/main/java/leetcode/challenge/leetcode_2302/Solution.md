Count Subarrays With Score Less Than K
      Hard
      Topics
      Companies
      Hint
      The score of an array is defined as the product of its sum and its length.

For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.

A subarray is a contiguous sequence of elements within an array.

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 1015

Let define S as the sum of all elements in the subarray, L is the size of subarray
S  * L < k
S always >= 1

To calculate all sums of sub arrays, we can use a prefix sum array (cumulative sum array)

Brute force solution:
Check every pair of indices i, j for i < j

Binary search solution:
Find smallest j for every i that i, j form a valid subarray. Then the number of valid subarrays starting from i is j - i
