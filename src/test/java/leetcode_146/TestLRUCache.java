package leetcode_146;

import leetcode.challenge.leetcode_146.ILRUCache;
import leetcode.challenge.shared.ListUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLRUCache {

    @Test
    public void testLRUCache() {
        ILRUCache lruCache = LRUCacheBuilder.build(2);
        // ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        // [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

        // null, null, null, 1, null, -1, null, -1, 3, 4]
        List<Integer> expectedResult = Arrays.asList(null, null, null, 1, null, -1, null, -1, 3, 4);

        List<String> actions = List.of("put", "put", "get", "put", "get", "put", "get", "get", "get");
        List<List<Integer>> parameters = Arrays.asList(
                List.of(1, 1),
                List.of(2, 2),
                List.of(1),
                List.of(3, 3),
                List.of(2),
                List.of(4, 4),
                List.of(1),
                List.of(3),
                List.of(4));

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i);
            List<Integer> parameter = parameters.get(i);
            if (action.equals("put")) {
                lruCache.put(parameter.get(0), parameter.get(1));
                result.add(null);
            } else if (action.equals("get")) {
                int resultValue = lruCache.get(parameter.get(0));
                result.add(resultValue);
            }
        }

        assert ListUtil.listEquals(result, expectedResult);
    }

    // ["LRUCache","get","put","get","put","put","get","get"]
    // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

    @Test
    public void testLRUCache2() {
        ILRUCache lruCache = LRUCacheBuilder.build(2);
        // ["LRUCache", "get", "put", "get", "put", "put", "get", "get"]
        // [[2], [2], [2, 6], [1], [1, 5], [1, 2], [1], [2]]

        // null, -1, null, -1, null, null, 2, 6]
        List<Integer> expectedResult = Arrays.asList(null, -1, null, -1, null, null, 2, 6);

        List<String> actions = List.of("get", "put", "get", "put", "put", "get", "get");
        List<List<Integer>> parameters = Arrays.asList(
                List.of(2), List.of(2, 6), List.of(1), List.of(1, 5), List.of(1, 2), List.of(1), List.of(2));

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i);
            List<Integer> parameter = parameters.get(i);
            if (action.equals("put")) {
                lruCache.put(parameter.get(0), parameter.get(1));
                result.add(null);
            } else if (action.equals("get")) {
                int resultValue = lruCache.get(parameter.get(0));
                result.add(resultValue);
            }
        }

        assert ListUtil.listEquals(result, expectedResult);
    }
}
