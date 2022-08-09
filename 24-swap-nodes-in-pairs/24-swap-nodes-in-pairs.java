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
     public ListNode swapPairs(ListNode head) {
        return helper(head);
    }
    
    public ListNode helper(ListNode current)
    {
        if(current==null || current.next == null)
        {
            return current;
        }
        ListNode temp =current.next;
        ListNode arg = temp.next;
        temp.next = current;
        current.next = helper(arg);
        return temp;
    }
}