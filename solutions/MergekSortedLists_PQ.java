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
    /*
    We maintain a k size heap to and pull them out until there's no element left.
    time O(nlogk) space O(k)
    */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> {
            return a.val - b.val;
        });
        for(ListNode head: lists){
            if(head != null) pq.add(head);
        }
        // Use dummy head to avoid redundant codes
        ListNode fakeHead = new ListNode(0), cur = fakeHead;
        
        while(!pq.isEmpty()){
            ListNode next = pq.poll();
            cur.next = next;
            if(next.next != null) pq.add(next.next);
            next.next = null;
            cur = cur.next;
        }
        
        return fakeHead.next;
    }
}