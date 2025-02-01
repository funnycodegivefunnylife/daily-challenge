package leetcode_729;

import leetcode.challenge.leetcode_729.MyCalendar;
import leetcode.challenge.shared.ListUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCalendar {

    @Test
    public void test() {
        MyCalendar myCalendar = new MyCalendar();
        List<Boolean> results = List.of(myCalendar.book(10, 20), myCalendar.book(15, 25), myCalendar.book(20, 30));

        List<Boolean> expected = List.of(true, false, true);

        assert ListUtil.listEquals(results, expected);
    }

    @Test
    public void test2() {
        MyCalendar myCalendar = new MyCalendar();
        List<Boolean> results = List.of(
                myCalendar.book(47, 50),
                myCalendar.book(33, 41),
                myCalendar.book(39, 45),
                myCalendar.book(33, 42),
                myCalendar.book(25, 32),
                myCalendar.book(26, 35),
                myCalendar.book(19, 25),
                myCalendar.book(3, 8),
                myCalendar.book(8, 13),
                myCalendar.book(18, 27));

        List<Boolean> expected = List.of(true, true, false, false, true, false, true, true, true, false);

        assert ListUtil.listEquals(results, expected);
    }
}
