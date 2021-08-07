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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        int len = 1;
        // we want the cur to locate the last node, so the length is initiated at 1
        ListNode cur = head;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        
        // To find the pre node we want, we recalculate the k value 
        k = len - (k % len);

        // if k == len, which means the same list after rotation
        if(k == len) return head;
        
        ListNode end = head;
        while(--k > 0){
            end = end.next;
        }

        // do the rotation
        cur.next = head;
        head = end.next;
        end.next = null;
        return head;
    }
}