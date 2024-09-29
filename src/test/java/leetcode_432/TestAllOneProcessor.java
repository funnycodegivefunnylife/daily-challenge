package leetcode_432;

import leetcode.challenge.leetcode_432.AllOneProcessor;
import leetcode.challenge.shared.ListUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAllOneProcessor {
    @Test
    public void test() {
        String[] operations = new String[]{"AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"};
        String[] values = new String[]{null, "hello", "hello", null, null, "leet", null, null};
        List<String> expected = Arrays.asList(null, null, null, "hello", "hello", null, "hello", "leet");
        List<String> process = AllOneProcessor.process(operations, values);
        assert ListUtil.listEquals(process, expected);
    }


    @Test
    public void test2() {
        String[] operations = new String[]{"AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"};
        String[] values = new String[]{null, "hello", "hello", null, null, "leet", null, null};
        List<String> expected = Arrays.asList(null, null, null, "hello", "hello", null, "hello", "leet");
        List<String> process = AllOneProcessor.process(operations, values);
        assert ListUtil.listEquals(process, expected);
    }

}
