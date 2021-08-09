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
     * We first locate the prev variable to the previous node of targeted reverse sequence
     * then we insert the start next node to the next of prev node iteratively
     * 
     * p    s    t
     * 1 -> 2 -> 3 -> 4 -> 5
     * p         s    t 
     * 1 -> 3 -> 2 -> 4 -> 5
     * 
     * time O(n) space O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        
        for(int i = 0; i < left - 1; i++) prev = prev.next;
        ListNode start = prev.next;
        ListNode then = start.next;
        
        for(int i = 0; i < right - left; i++){
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}