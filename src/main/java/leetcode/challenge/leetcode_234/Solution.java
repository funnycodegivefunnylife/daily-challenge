package leetcode.challenge.leetcode_234;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder buildFromRight = new StringBuilder();
        StringBuilder buildFromLeft = new StringBuilder();

        while (head != null) {
            buildFromRight.append(head.val);
            buildFromLeft.insert(0, head.val);
            head = head.next;
        }

        return buildFromRight.toString().contentEquals(buildFromLeft.toString());
    }
}
