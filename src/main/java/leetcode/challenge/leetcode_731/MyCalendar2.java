package leetcode.challenge.leetcode_731;

import java.util.TreeMap;

interface Bookable {
    boolean book(int start, int end);
}

class MapTimestamp implements Bookable {
    private TreeMap<Integer, Integer> map;

    public MapTimestamp() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int v : map.values()) {
            active += v;
            if (active == 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                return false;
            }
        }
        return true;
    }
}

public class MyCalendar2 {
    private Bookable bookable;

    public MyCalendar2() {
        this.bookable = new MapTimestamp();
    }

    public boolean book(int start, int end) {
        return bookable.book(start, end);
    }
}
