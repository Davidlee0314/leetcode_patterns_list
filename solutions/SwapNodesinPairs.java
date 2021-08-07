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
     * time O(n) space O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0), cur = fakeHead;
        fakeHead.next = head;
        
        while(cur.next != null && cur.next.next != null){
            ListNode odd = cur.next, even = cur.next.next;
            odd.next = even.next;
            even.next = odd;
            cur.next = even;
            cur = odd;
        }
        
        return fakeHead.next;
    }
}