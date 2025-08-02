3480. Maximize Subarrays After Removing One Conflicting Pair
      Hard
      Topics
      premium lock icon
      Companies
      Hint
      You are given an integer n which represents an array nums containing the numbers from 1 to n in order. Additionally, you are given a 2D array conflictingPairs, where conflictingPairs[i] = [a, b] indicates that a and b form a conflicting pair.

Remove exactly one element from conflictingPairs. Afterward, count the number of non-empty subarrays of nums which do not contain both a and b for any remaining conflicting pair [a, b].

Return the maximum number of subarrays possible after removing exactly one conflicting pair.

Step 1: Find an ideal pair to remove
- Given arr [1...n]
- Pair (a, b) is ideal pair if the difference between a and b is minimal


Step 2: Count numbers of remaing subarrays that do not contain conflics pair
