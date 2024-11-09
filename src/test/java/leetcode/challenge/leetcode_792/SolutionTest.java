package leetcode.challenge.leetcode_792;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();


    @Test
    void test1() {
        String s = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        assertEquals(3, solution.numMatchingSubseq(s, words));
    }


    @Test
    void test2() {
        String s = "dsahjpjauf";
        String[] words = new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        assertEquals(2, solution.numMatchingSubseq(s, words));
    }


    @Test
    void test3() {
        String s = "rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac";
        String[] words = new String[]{"wpddkvbnn","lnagtva","kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju","rwpddkvbnnugln","gloeofnpjqlkdsqvruvabjrikfwronbrdyyj","vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos","mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina","rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip","fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq","qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"};
        assertEquals(5, solution.numMatchingSubseq(s, words));
    }

    @Test
    void test4() {
        String s = "abcde";
        String[] words = new String[]{"a","bab","a","ace"};
        assertEquals(3, solution.numMatchingSubseq(s, words));
    }

    @Test
    void test5() {
        String s = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        assertEquals(3, solution.numMatchingSubseq(s, words));
    }

    @Test
    void test6() {
        String s = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        assertEquals(3, solution.numMatchingSubseq(s, words));
    }
}