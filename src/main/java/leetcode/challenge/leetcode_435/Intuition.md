435. Non-overlapping Intervals
     Medium
     Topics
     premium lock icon
     Companies
     Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.


To solve this problem, we can use a greedy approach.
Characteristics of the problem:
- A element that is appropriate to remove is the one that has the large end time?
For given two intervals [a, b] and [c, d], if b <= c, then [e, f] is overlapping with [a, b] and [c, d] if and only if e < c or f > b.