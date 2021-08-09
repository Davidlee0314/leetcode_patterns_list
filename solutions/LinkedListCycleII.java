/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * Suppose the distance from head to the cycle start is A,
     * from the cycle start to the fast / slow meet node is B,
     * from fast / slow meet node to to the cycle start is C,
     * 
     * So the formula will be:
     * A + B + k(B + C) = 2(A + B) -> fast pointer can run k cycles to meet the slow
     * ->  A = (k - 1)(B + C) + C 
     * -> we don't care about (k - 1)(B + C) cuz they don't influence the position
     * -> A = C
     * 
     * time O(n) space O(1)
     */
    public ListNode detectCycle(ListNode head) {
        // empty list or one node list
        if(head == null || head.next == null) return null;
        
        ListNode slow = head.next, fast = head.next.next;
        while(slow != fast && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // no cycle
        if(fast == null || fast.next == null) return null;
        
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}