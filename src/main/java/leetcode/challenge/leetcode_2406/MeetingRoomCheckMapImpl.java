package leetcode.challenge.leetcode_2406;

import java.util.List;

class BookingEvent {
    int time;
    boolean isStart;
}

public class MeetingRoomCheckMapImpl implements MeetingRoomCheck{
    @Override
    public int minGroups(int[][] intervals) {
        List<BookingEvent> events = new java.util.ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            BookingEvent startEvent = new BookingEvent();
            startEvent.time = intervals[i][0];
            startEvent.isStart = true;
            events.add(startEvent);

            BookingEvent endEvent = new BookingEvent();
            endEvent.time = intervals[i][1];
            endEvent.isStart = false;
            events.add(endEvent);
        }

        // sort by time and let booking start event come first
        events.sort((a, b) -> a.time == b.time ? Boolean.compare(a.isStart, b.isStart) : Integer.compare(a.time, b.time));

        int maxBooking = 0;
        int currentBooking = 0;

        for (BookingEvent event : events) {
            if (event.isStart) {
                currentBooking++;
                maxBooking = Math.max(maxBooking, currentBooking);
            } else {
                currentBooking--;
            }
        }

        return maxBooking;
    }
}
