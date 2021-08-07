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
    public ListNode reverseKGroup(ListNode head, int k) {
        // if k == 1, then the list will not be changed
        if(k == 1) return head;
        
        // we use the dummy so that we can assign prev element to the previous node of k-size list
        ListNode dummy = new ListNode(0), start = dummy;
        dummy.next = head;
        while(true){
            ListNode prev = start, slow = null, fast = start;

            // start is the start of the k-size list, and it will be at the end of k-size list after the reversion,
            // and that's why we assign prev to start in the start of the loop
            start = prev.next;

            // fast will run toward the end of the k-size list, if fast is null value, then the list is not long enough
            for(int i = 0; i < k && fast != null; i++) fast = fast.next;
            if(fast == null) break;
            
            // Ex. k == 4
            // before:      prev -> 1 -> 2 -> 3 -> 4 -> next
            // iteration 1: prev -> 2 -> 3 -> 4 -> 1 -> next
            // iteration 2: prev -> 3 -> 4 -> 2 -> 1 -> next
            // iteration 3: prev -> 4 -> 3 -> 2 -> 1 -> next
            // the fast node will always point to the last node in unreversed list (which is 4 in the example)
            // so in every iteration, we put the prev.next node to the next of the fast node
            for(int i = 0; i < k - 1; i++){
                slow = prev.next;
                prev.next = slow.next;
                slow.next = fast.next;
                fast.next = slow;
            }
        }
        return dummy.next;
    }
}