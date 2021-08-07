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
class Solution {
    /**
     * We maintain a fast and a slow pointers and their distance is n.
     * So we can iterate fast toward the list end and remove slow next node.
     * time O(n) space O(1) 
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0), fast = fakeHead, slow = fakeHead;
        fakeHead.next = head;
        while(n-- >= 0) fast = fast.next;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return fakeHead.next;
    }
}