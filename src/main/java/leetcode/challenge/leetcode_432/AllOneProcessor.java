package leetcode.challenge.leetcode_432;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AllOneProcessor {

    public static List<String> process(String[] operations, String[] values) {
        AllOneInterface allOne = null;
        List<Operation> operationList = Stream.of(operations).map(Operation::valueOf).toList();
        List<String> valueList = Stream.of(values).toList();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < operationList.size(); i++) {
            Operation operation = operationList.get(i);
            String value = valueList.get(i);
            switch (operation) {
                case AllOne:
                    allOne = new AllOne();
                    result.add(null);
                    break;
                case inc:
                    allOne.inc(value);
                    result.add(null);
                    break;
                case dec:
                    allOne.dec(value);
                    result.add(null);
                    break;
                case getMaxKey:
                    result.add(allOne.getMaxKey());
                    break;
                case getMinKey:
                    result.add(allOne.getMinKey());
                    break;
            }
        }

        return result;
    }
}
