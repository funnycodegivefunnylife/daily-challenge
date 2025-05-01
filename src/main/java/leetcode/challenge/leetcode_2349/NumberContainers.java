package leetcode.challenge.leetcode_2349;

import java.util.Map;
import java.util.SortedSet;

class NumberContainers {
    Map<Integer, SortedSet<Integer>> numberToIndex;
    Map<Integer, Integer> indexToNumber;

    public NumberContainers() {
        numberToIndex = new java.util.HashMap<>();
        indexToNumber = new java.util.HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            removeFromNumberToIndex(index);
        }

        addToNumberToIndex(index, number);
    }

    private void addToNumberToIndex(int index, int number) {
        indexToNumber.put(index, number);
        SortedSet<Integer> indexes = numberToIndex.computeIfAbsent(number, k -> new java.util.TreeSet<>());
        indexes.add(index);
    }

    private void removeFromNumberToIndex(int index) {
        int number = indexToNumber.get(index);
        SortedSet<Integer> indexes = numberToIndex.get(number);
        indexes.remove(index);
        if (indexes.isEmpty()) {
            numberToIndex.remove(number);
        }
    }

    public int find(int number) {
        SortedSet<Integer> indexes = numberToIndex.get(number);
        if (indexes == null) {
            return -1;
        }

        return indexes.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
