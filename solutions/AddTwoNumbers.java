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
     * time O(n) space O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0), cur = fakeHead;
        int val = 0;
        
        while(l1 != null || l2 != null){
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
                
            val /= 10;
            cur = cur.next;
        }
        
        if(val > 0) cur.next = new ListNode(val);
        return fakeHead.next;
    }
}