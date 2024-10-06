package util;

import leetcode.challenge.shared.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLongestCommonPrefixSuffix {

    @Test
    @DisplayName("Given strings 'ab' and 'ab', the method should return 'ab'")
    public void test1() {
        String s1 = "ab";
        String s2 = "ab";
        String result = StringUtil.longestCommonPrefix(s1, s2);
        assert "ab".equals(result);
    }

    @Test
    @DisplayName("Given strings 'ab' and 'cd', the method should return ''")
    public void test2() {
        String s1 = "ab";
        String s2 = "cd";
        String result = StringUtil.longestCommonPrefix(s1, s2);
        assert "".equals(result);
    }

    @Test
    @DisplayName("Given strings 'abcd' and 'cd', the method should return 'cd'")
    public void test3() {
        String s1 = "abcd";
        String s2 = "cd";
        String result = StringUtil.longestCommonSuffix(s1, s2);
        assert "cd".equals(result);
    }
}
