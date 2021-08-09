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
     * We record the head and the moving cur node for both list,
     * then we concatenate two lists.
     * time O(n) space O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(0), curLess = dummyLess, dummyGreater = new ListNode(0), curGreater = dummyGreater;
        while(head != null){
            if(head.val < x){
                curLess.next = head;
                curLess = curLess.next;
            }else{
                curGreater.next = head;
                curGreater = curGreater.next;
            }
            head = head.next;
        }
        curLess.next = dummyGreater.next;
        curGreater.next = null;
        return dummyLess.next;
    }
}