package leetcode.challenge.shared;

public class StringUtil {
    public static String longestCommonPrefix(String s1, String s2) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
            sb.append(s1.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static String longestCommonSuffix(String s1, String s2) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s1.length() && i < s2.length() && s1.charAt(s1.length() - 1 - i) == s2.charAt(s2.length() - 1 - i)) {
            sb.append(s1.charAt(s1.length() - 1 - i));
            i++;
        }
        return sb.reverse().toString();
    }

    public static int sizeOfLongestCommonPrefix(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }

    public static int sizeOfLongestCommonSuffix(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(s1.length() - 1 - i) == s2.charAt(s2.length() - 1 - i)) {
            i++;
        }
        return i;
    }

    public static int sizeOfLongestCommonPrefix(String[] words1, String[] words2) {
        int i = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        return i;
    }

    public static int sizeOfLongestCommonSuffix(String[] words1, String[] words2) {
        int i = 0;
        while (i < words1.length
                && i < words2.length
                && words1[words1.length - 1 - i].equals(words2[words2.length - 1 - i])) {
            i++;
        }
        return i;
    }
}
