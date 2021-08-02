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
    Adopt divide and conquer to partition lists and merge them.
    time partition O(logk) merge O(n) -> O(nlogk)
    space O(1)
    */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);
    }
    private ListNode partition(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode l1 = partition(lists, start, mid),
                l2 = partition(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode fakeHead = new ListNode(0), cur = fakeHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null){
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return fakeHead.next;
    }
}