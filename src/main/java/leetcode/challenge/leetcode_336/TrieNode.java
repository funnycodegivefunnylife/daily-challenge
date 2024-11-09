package leetcode.challenge.leetcode_336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class StringUtil {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static String reverse(String input) {
        byte[] strAsByteArray = input.getBytes();

        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        return new String(result);
    }
}


class Trie {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public void insert(int index, String s) {
        indexMap.put(s.hashCode(), index);
    }

    public int indexOfReverse(String s) {
        return indexMap.getOrDefault(StringUtil.reverse(s).hashCode(), -1);
    }
}


class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        Trie searchEngine = new Trie();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            searchEngine.insert(i, words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);

                if (StringUtil.isPalindrome(left)) {
                    int index = searchEngine.indexOfReverse(right);
                    if (index != -1 && index != i) {
                        result.add(List.of(index, i));
                    }
                }

                if (!right.isEmpty() && StringUtil.isPalindrome(right)) {
                    int index = searchEngine.indexOfReverse(left);
                    if (index != -1 && index != i) {
                        result.add(List.of(i, index));
                    }
                }

            }
        }

        return result;
    }

}